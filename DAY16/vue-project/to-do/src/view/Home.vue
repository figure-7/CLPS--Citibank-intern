<template>
  <div>
    <h2 v-if="!noToDo && !backendServiceFailed && !loading">To-Do list...</h2>
    <h2 v-if="!noToDo && backendServiceFailed && !loading">数据加载失败...</h2>
    <div v-if="noToDo">
      <div>还没有待办事项？赶快来添加吧！</div>
      <div>
        <el-row>
          <el-button type="primary" icon="el-icon-edit" circle class="el-button-size-30"></el-button>
        </el-row>
      </div>
    </div>
    <el-row>
      <el-col class="todo-item" :span="24" v-for="(todo, index) in toDos" :key="index">
        <ToDoItem :data="todo"></ToDoItem>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import axios from "axios";
import ToDoItem from "../components/To-do-item";
import { mapGetters } from "vuex";

export default {
  computed: {
    // mapGetters 辅助函数仅仅是将 store 中的 getter 映射到局部计算属性，省去了this.$store.getters.allToDos这样的写法
    ...mapGetters({
      allToDos: "allToDos"
    }),
    toDoList: {
      get() {
        // 第一次this.allToDos也为空
        // console.log(345678);
        // console.log(this.allToDos);
        // this.toDoList直接引用了store里的allToDos
        return this.allToDos;
      },
      set(newVal) {
        // 当发生（数据）变化时。。。
        this.$store.commit("updateAllToDos", newVal);
      }
    }
  },
  components: {
    ToDoItem
  },
  data() {
    return {
      toDos: [],
      noToDo: true,
      backendServiceFailed: false,
      loading: true
    };
  },
  async created() {
    try {
      console.log("to get data from remote service...");
      let result = await axios.get("/api/toDoService/toDos");
      console.log(result.data[0].summary);
      console.log(result.data[0]["summary"]);
      this.toDos = result.data;
      // 触发了toDoList的set方法
      this.toDoList = this.toDos || [];
      if (this.toDoList.length > 0) {
        this.noToDo = false;
      }
      this.loading = false;
    } catch (e) {
      console.log("back-end service request failed...");
      console.log(e);
      this.toDos = this.toDoList;
      if (this.toDos.length == 0) {
        this.backendServiceFailed = true;
        this.noToDo = false;
      }
      this.loading = false;
    }
  }
};
</script>

<style>
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.max-row-height {
  line-height: 50px;
}
.todo-item {
  background: rgba(0, 0, 0, 0.04);
  border-color: orchid;
  margin: 10px 0 10px 0;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.el-button-size-30 {
  font-size: 30px !important;
}
</style>