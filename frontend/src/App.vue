<template>
  <v-app>

    <!-- <v-app-bar app>
    </v-app-bar> -->

    <v-main>
      <v-container fluid>
        <UploadView v-if="viewKind === 'upload'" />
        <ResultViewVue v-if="viewKind === 'get'" />
        <BatchView v-if="viewKind === 'batch'"/>
        <!-- <router-view /> -->
      </v-container>
    </v-main>

    <NavigationVue @setViewKind="setViewKind"/>
  </v-app>
</template>

<script>
import NavigationVue from './components/navigation/Navigation.vue';
import UploadView from './views/UploadView.vue';
import ResultViewVue from './views/ResultView.vue';
import BatchView from './views/BatchView.vue';

export default {
  name: 'App',
  components: {
    NavigationVue, UploadView, ResultViewVue, BatchView
  },
  data: () => ({
    viewKind:'upload'
  }),
  methods:{
    setViewKind(val) {
      this.viewKind = val
      // this.$router.push(`/${this.viewKind}`);
    }
  }
};
</script>
