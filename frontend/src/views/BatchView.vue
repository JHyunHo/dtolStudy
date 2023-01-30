<template>
    <v-row>
      <ButtonVue propColor="brown"
                    propLabel="Batch"
                    propIcon="mdi-file-upload-outline"
                    @submit="submit"
      />
      <ProgressCircleVue v-if="isSubmit"/>
    </v-row>
</template>

<script>
import ButtonVue from '@/components/button/Button.vue';
import ProgressCircleVue from '@/components/progress/ProgressCircle.vue';

export default {
  name: 'BatchViewVue',
  components : {
    ProgressCircleVue,
    ButtonVue
  }, 
  data: () => ({
    file: [],
    isSubmit : false
  }),
  methods:{
    inputFile (val) {
        this.file = val
    },
    submit () {
        this.isSubmit = true
    }
  }
};
</script>