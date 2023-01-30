<template>
    <v-bottom-navigation
      v-model="buttonValue"
      :background-color="color"
      dark
      shift
    >
      <v-li v-for="item in buttonList" :key="item.sapn" :style="{ paddingTop: '10px' }">
        <v-btn @click="onClick(item.span)">
          {{ item.span }}
          <v-icon>{{ item.icon }}</v-icon>
        </v-btn>
      </v-li>
    </v-bottom-navigation>
</template>

<script>
export default {
    nanme : 'NavigationVue',
    data: () => ({
      buttonValue: 0,
      buttonList : [
        {span : 'upload', icon: 'mdi-arrow-up-bold-box-outline'},
        {span : 'get', icon: 'mdi-widgets-outline'},
        {span : 'batch', icon: 'mdi-loading'}
      ],
    }),
    methods:{
      onClick(val) {
        this.$emit('setViewKind', val)
      }
    },
    computed: {
        color () {
            switch (this.buttonValue) {
                case 0: return 'blue-grey'
                case 1: return 'teal'
                case 2: return 'brown'
                default: return 'blue-grey'
            }
        },
    },
}
</script>
