import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from './view/Home';
import ToDo from './view/To-do';

Vue.use(VueRouter);

let router = new VueRouter({
    mode: "history",
    routes: [
        {
            path: '/',
            component: Home,
            name: 'home'
        },
        {
            path: '/toDo',
            component: ToDo,
            name: 'toDo'
        }
    ]
});

export default router;