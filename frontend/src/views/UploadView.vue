<template>
    <v-row>
        <v-file-input accept=".csv" label="File input" v-model="file" @change="inputFile"/>
        <ButtonVue propColor="blue-grey"
                    propLabel="Upload"
                    propIcon="mdi-file-upload-outline"
                    @submit="submit"
        />
    </v-row>
</template>

<script>
import ButtonVue from '@/components/button/Button.vue';
import {POST_API} from '@/conts/api'

export default {
  name: 'UploadViewVue',
  components: {ButtonVue},
  data: () => ({
    file: []
  }),
  methods:{
    inputFile (val) {
        this.file = val
    },
    submit () {
        this.file?.type ? POST_API(this.file) : alert('파일을 입력하세요')
    }
  }
};
</script>