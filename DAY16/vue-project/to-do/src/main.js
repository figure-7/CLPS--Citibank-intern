import Vue from 'vue';
import App from './App.vue';
import router from './router';
import ElementUI from "element-ui";
import store from './store';
import "element-ui/lib/theme-chalk/index.css";

Vue.use(ElementUI);

Vue.config.productionTip = false

// 在全局Vue对象中注入了store、router，就可以在全局的vue单文件中直接通过this.xxx来使用。
new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app')

// 定义全局函数，直接通过this.getUUID()来使用。
Vue.prototype.getUUID = function () {
  function S4() {
    return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
  }
  return (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
}