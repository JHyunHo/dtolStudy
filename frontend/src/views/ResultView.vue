<template>
    <v-row>
      <v-col>
        <v-row>
          <v-col cols="4"><DatePicker/></v-col>
          <v-col cols="3"><SelectVue propLabel="호선명"/></v-col>
          <v-col cols="3"><SelectVue propLabel="역명"/></v-col>
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
          <v-col>그리드 결과</v-col>
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
import {GET_API} from '@/conts/api'

export default {
  name: 'ResultViewVue',
  components: {
    DatePicker,
    SelectVue,
    ButtonVue
  }, 
  data: () => ({
      dates: [],
  }),
  /* 옵션 api 초기화 */
  created() {
    GET_API()
  },
  methods:{
    submit() {
      console.log('조회')
    }
  }
};
</script>

