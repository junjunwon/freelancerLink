import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import {store} from "@/components/store";
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import vuetify from './plugins/vuetify'
// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)

Vue.config.productionTip = false
Vue.prototype.$axios = axios

new Vue({
  router,
  store : store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
