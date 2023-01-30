<template>
      <v-select
        :items="items"
        :label="label"
        />
</template>

<script>
  export default {
    name : 'SelectVue',
    props : {
      propLabel : String
    }, 
    data: () => ({
      items: ['Foo', 'Bar', 'Fizz', 'Buzz'],
    }),
    mounted:{
      
    },
    computed : {
      label() {
        return this.$props.propLabel
      }
    }
  }
</script>