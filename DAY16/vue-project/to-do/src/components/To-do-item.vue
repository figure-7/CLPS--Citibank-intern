<template>
  <div>
    <div class="grid-content max-row-height" @click="editToDo()">
      <div class="summary">{{data.summary}}</div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["data"], // 拿到父组件的data属性（todo），但这里要一直使用data来指代传进来的todo
  methods: {
    editToDo() {
      this.$router.push({
        name: "toDo",
        query: { action: "modifyToDo" },
        params: { selectedToDo: this.data }
      });
    }
  }
};
</script>

<style>
.summary {
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
  padding: 0 10px;
}
</style>