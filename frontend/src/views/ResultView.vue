<template>
    <v-row>
      <v-col>
        <v-row>
          <v-col cols="4"><DatePicker @onOk="onOk"/></v-col>
          <v-col cols="3"><SelectVue propLabel="호선명" :propItem="searchLines" @onSearch="onSearch" :propMultiple="false"/></v-col>
          <v-col cols="3"><SelectVue propLabel="역명"   :propItem="searchStations" @onSearch="onSearch" :propMultiple="true"/></v-col>
          <v-col>
            <ButtonVue propColor="teal"
                    propLabel="Search"
                    propIcon="mdi-magnify"
                    @submit="submit"
            />
          </v-col>
        </v-row>
        <v-divider />
        <v-spacer />
        <v-row>
          <v-col><GridVue :propColumnDefs="gridColDefs" :propRowData="gridRowData"/></v-col>
          <v-divider vertical/>
          <v-col><BarChartVue :propChartData="gridRowData"/></v-col>
        </v-row>
      </v-col>
    </v-row>
</template>

<script>
import ButtonVue from '@/components/button/Button.vue';
import DatePicker from '@/components/search/DatePicker'
import SelectVue from '@/components/search/Select'
import GridVue from '@/components/grid/Grid.vue';
import BarChartVue from '@/components/chart/BarChart.vue';
import {GET_API} from '@/conts/api'
import _ from 'lodash'

export default {
  name: 'ResultViewVue',
  components: {
    DatePicker,
    SelectVue,
    ButtonVue,
    GridVue,
    BarChartVue
  }, 
  data: () => ({
      searchData : {},
      searchDates: [],
      searchLines : [],
      searchStations : [],
      date : null,
      line : null,
      station : null,
      gridColDefs : [
          // { field: 'line_num', sortable: true, filter: true },
          { headerName:'역명', field: 'sub_sta_nm', sortable: true, filter: true },
          { headerName:'승차객 수', field: 'ride_pasgr_num', sortable: true, filter: true},
          { headerName:'하차객 수', field: 'alight_pasgr_num', sortable: true, filter: true },
          // { headerName:'이용 일자', field: 'use_dt', sortable: true, filter: true, /* checkboxSelection: true */ },
      ],
      gridRowData : null,
  }),
  /* 옵션 api 초기화 */
  created() {
    GET_API().then(res => {
        this.searchData = res
        this.searchLines = _.orderBy(_.uniq(res.map(item => item.line_num)))
    })
  },
  methods:{
    onOk(val) {
      this.date = val
    },
    onSearch(val, kind) {
      if (kind === '호선명') {
        this.line = val
        this.searchStations = _.orderBy(_.uniq(this.searchData.map(item => {if (item.line_num === val) return item.sub_sta_nm})))
      } else {
        this.station = val
      }
    },
    submit() {
      if (!this.line || !this.station?.length) {
        alert("조회조건은 필수입니다.")
        return
      }
      let formatDate = this.date.replaceAll('-','')
      let filterDate = _.filter(this.searchData, {'use_dt' : formatDate})
      let filterData = _.filter(filterDate, {'line_num' : this.line})
      let tmpRowData = []
      filterData.forEach(item => {
        this.station.forEach(station => {
          if (item.sub_sta_nm === station) {
            tmpRowData.push(item)
          }
        })
      })
      this.gridRowData = _.orderBy(tmpRowData, 'sub_sta_nm')
    }
  }
};
</script>

