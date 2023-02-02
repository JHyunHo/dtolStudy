<template>
      <v-select
        :items="items"
        :label="label"
        @input="changeInput"
        :multiple="multiple"
        />
</template>

<script>
  export default {
    name : 'SelectVue',
    props : {
      propLabel : String,
      propItem : Array,
      propMultiple : Boolean
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
      },
      multiple() {
        return this.$props.propMultiple
      }
    }
  }
</script>