<template>
    <v-row>
      <v-col>
        <v-row>
          <v-col cols="4"><DatePicker/></v-col>
          <v-col cols="3"><SelectVue propLabel="호선명" :propItem="searchLines" @onSearch="onSearch"/></v-col>
          <v-col cols="3"><SelectVue propLabel="역명"   :propItem="searchStations" @onSearch="onSearch"/></v-col>
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
          <v-col>차트 결과</v-col>
        </v-row>
      </v-col>
    </v-row>
</template>

<script>
import ButtonVue from '@/components/button/Button.vue';
import DatePicker from '@/components/search/DatePicker'
import SelectVue from '@/components/search/Select'
import GridVue from '@/components/grid/Grid.vue';
import {GET_API} from '@/conts/api'
import _ from 'lodash'

export default {
  name: 'ResultViewVue',
  components: {
    DatePicker,
    SelectVue,
    ButtonVue,
    GridVue
  }, 
  data: () => ({
      searchData : {},
      searchDates: [],
      searchLines : [],
      searchStations : [],
      line : null,
      station : null,
      gridColDefs : [
          { field: 'use_dt', sortable: true, filter: true, checkboxSelection: true },
          { field: 'line_num', sortable: true, filter: true },
          { field: 'sub_sta_nm', sortable: true, filter: true }
      ],
      gridRowData : null
  }),
  /* 옵션 api 초기화 */
  created() {
    GET_API().then(res => {
        this.searchData = res
        this.searchLines = _.orderBy(_.uniq(res.map(item => item.line_num)))
    })
  },
  methods:{
    onSearch(val, kind) {
      if (kind === '호선명') {
        this.line = val
        this.searchStations = _.orderBy(_.uniq(this.searchData.map(item => {if (item.line_num === val) return item.sub_sta_nm})))
      } else {
        this.station = val
      }
    },
    submit() {
      if (!this.line || !this.station) {
        alert("조회조건은 필수입니다.")
        return
      }
      this.gridRowData = this.searchData.filter(item => {
        if (item.line_num === this.line && item.sub_sta_nm === this.station) return item
      })
    }
  }
};
</script>

