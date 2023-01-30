import Vue from 'vue'
import Router from 'vue-router'
import UploadViewVue from './views/UploadView.vue'
import ListViewVue from './views/ListVue.vue'

Vue.use(Router)

const router =  new Router({
  routes: [
    {
      path: '/upload',
      name: 'upload',
      component: UploadViewVue
    },
    {
      path: '/list',
      name: 'list',
      component: ListViewVue
    }
  ]
})
export default router
