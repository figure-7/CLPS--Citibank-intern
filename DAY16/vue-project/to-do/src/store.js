import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex)

let store = new Vuex.Store({
    // 全局通过state属性来传递全局的数据
    state: {
        toDoItemsInHomePage: JSON.parse(localStorage.getItem("toDoItemsInHomePage")) || []
    },
    // 通过this.$store.commit("toDoAdd", toDo);这样的方式触发全局数据的变化，进而调用具体事件
    mutations: {
        // 第一个参数默认永远都是state，但是调用者不必显示传递state
        toDoAdd(state, toDo) {
            state.toDoItemsInHomePage.push({ ...toDo });
        },
        toDoModify(state, modifiedToDo) {
            let selectedToDo = state.toDoItemsInHomePage.find(v => v.id == modifiedToDo.id);
            selectedToDo.summary = modifiedToDo.summary;
            selectedToDo.startDateTime = modifiedToDo.startDateTime;
            selectedToDo.endDateTime = modifiedToDo.endDateTime;
            selectedToDo.status = modifiedToDo.status;
        },
        updateAllToDos(state, newVal) {
            state.toDoItemsInHomePage = newVal;
        }
    },
    // 通过getter从store中派生出allToDos，供其他组件复用
    // getter中定义的属性相当于store自己的计算属性，计算属性只有在依赖数据发生变化时才会重新计算，否则会读取缓存
    getters: {
        allToDos: state => {
            //第一次进入程序，state.toDoItemsInHomePage肯定为空
            // console.log(12345);
            // console.log(state.toDoItemsInHomePage);
            return state.toDoItemsInHomePage;
        }
    }
});

store.subscribe((mutations, state) => {
    // 捕获mutations，即当触发任何变化时。。。
    localStorage.setItem("toDoItemsInHomePage", JSON.stringify(state.toDoItemsInHomePage));
});

export default store;