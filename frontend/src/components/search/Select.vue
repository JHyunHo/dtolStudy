<template>
      <v-select
        :items="items"
        :label="label"
        @input="changeInput"
        />
</template>

<script>
  export default {
    name : 'SelectVue',
    props : {
      propLabel : String,
      propItem : Array
    }, 
    mounted:{
     
    },
    methods : {
      changeInput(val) {
        this.$emit('onSearch', val, this.label)
      }
    },
    computed : {
      label() {
        return this.$props.propLabel
      },
      items() {
        return this.$props.propItem
      }
    }
  }
</script>