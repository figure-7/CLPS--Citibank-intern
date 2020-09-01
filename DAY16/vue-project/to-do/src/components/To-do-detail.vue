<template>
  <div>
    <div class="el-input">
      <div class="el-input-title">
        Summary
        <span class="mandatory-field">*</span>
      </div>
      <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="summary"></el-input>
      <div class="space"></div>
      <div class="el-input-title">
        Planned Start DateTime
        <span class="mandatory-field">*</span>
      </div>
      <el-date-picker
        value-format="yyyy-MM-dd HH:mm:ss"
        v-model="startDateTime"
        type="datetime"
        placeholder="选择日期时间"
      ></el-date-picker>
      <div class="space"></div>
      <div class="el-input-title">
        Planned End DateTime
        <span class="mandatory-field">*</span>
      </div>
      <el-date-picker
        value-format="yyyy-MM-dd HH:mm:ss"
        v-model="endDateTime"
        type="datetime"
        placeholder="选择日期时间"
      ></el-date-picker>
      <div class="space"></div>
      <div v-if="this.isModifyView" class="el-input-title">Status</div>
      <el-select v-if="this.isModifyView" v-model="status" placeholder="请选择">
        <el-option v-for="value in statusOptions" :key="value" :label="value" :value="value"></el-option>
      </el-select>
    </div>
    <el-button
      v-if="!this.isModifyView"
      type="primary"
      class="el-button-width-100"
      @click="addToDo()"
    >Add</el-button>
    <el-button
      v-if="this.isModifyView"
      type="primary"
      class="el-button-width-100"
      @click="modifyToDo()"
    >Modify</el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      summary: "",
      startDateTime: "",
      endDateTime: "",
      isModifyView: false,
      statusOptions: ["In Progress", "Terminate", "Complete", "Closed"],
      status: "",
      selectedToDo: ""
    };
  },
  methods: {
    addToDo() {
      let uuid = this.getUUID();
      let summary = this.summary;
      let startDateTime = this.startDateTime;
      let endDateTime = this.endDateTime;
      let toDo = {};
      toDo["id"] = uuid;
      toDo["summary"] = summary;
      let now = new Date();
      toDo["creatDateTime"] =
        now.getFullYear() +
        "-" +
        (String(now.getMonth() + 1).length == 1
          ? "0" + (now.getMonth() + 1)
          : now.getMonth() + 1) +
        "-" +
        (String(now.getDate()).length == 1
          ? "0" + now.getDate()
          : now.getDate()) +
        " " +
        (String(now.getHours()).length == 1
          ? "0" + now.getHours()
          : now.getHours()) +
        ":" +
        (String(now.getMinutes()).length == 1
          ? "0" + now.getMinutes()
          : now.getMinutes()) +
        ":" +
        (String(now.getSeconds()).length == 1
          ? "0" + now.getSeconds()
          : now.getSeconds());
      toDo["startDateTime"] = startDateTime;
      toDo["endDateTime"] = endDateTime;
      toDo["status"] = "New";

      // 通过事件向父组件传递数据
      this.$emit("toDoAdd_Parent", toDo);
      // this.$store.commit("toDoAdd", toDo);
      // this.$router.push("/");
    },
    modifyToDo() {
      let modifiedToDo = {};
      modifiedToDo.summary = this.summary;
      modifiedToDo.startDateTime = this.startDateTime;
      modifiedToDo.endDateTime = this.endDateTime;
      modifiedToDo.status = this.status;
      modifiedToDo.id = this.selectedToDo.id;

      this.$emit("modifyToDo_Parent", modifiedToDo);
    }
  },
  created() {
    if ("modifyToDo" == this.$route.query.action) {
      this.isModifyView = true;
      this.selectedToDo = this.$route.params.selectedToDo;
      this.summary = this.selectedToDo.summary;
      this.startDateTime = this.selectedToDo.startDateTime;
      this.endDateTime = this.selectedToDo.endDateTime;
      this.status = this.selectedToDo.status;
    } else {
      this.isModifyView = false;
      this.summary = "";
      this.startDateTime = "";
      this.endDateTime = "";
    }
  }
};
</script>

<style>
.mandatory-field {
  color: red;
  font-weight: bold;
}
.el-select {
  width: 100%;
}
</style>