import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter);

// import Login from "@/components/login/Login";

const router = new VueRouter({
    mode : 'history',
    routes : [
        // {path:'/', name:'login', components: {login : Login} },
        {
            path : '/',
            name : 'login',
            component : () => import('@/components/login/Login.vue'),
        },
        {
            path : '/board/list',
            name : 'list',
            component : () => import('@/components/board/List.vue'),
        },
        {
            path : '/board/write',
            name : 'write',
            component : () => import('@/components/board/Input.vue')
        }
    ]
})
export default router