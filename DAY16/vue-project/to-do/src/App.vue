<template>
  <div>
    <el-container>
      <el-header>
        <div style="font-size: 20px;">
          <div style="display: flow-root;">
            <span style="float: left; padding-left: 10px; color: white;">您好，XXX！</span>
            <span style="float: right; padding-right: 10px;">
              <i class="el-icon-search"></i>
            </span>
          </div>
        </div>
        <!-- <el-menu
          :default-active="activeMenu($route.path)"
          active-text-color="#409EFF"
          mode="horizontal"
          @select="handleMenuSelect"
        >-->
        <el-menu
          :default-active="activeMenu($route.path)"
          active-text-color="#409EFF"
          mode="horizontal"
        >
          <el-menu-item
            index="1"
            :class="{selectMenuFontWeight: this.activeMenu($route.path) == '1'}"
          >
            <router-link to="/">Home</router-link>
          </el-menu-item>
          <el-menu-item
            index="2"
            :class="{selectMenuFontWeight: this.activeMenu($route.path) == '2'}"
          >
            <router-link to="/toDo">Add To-Do</router-link>
          </el-menu-item>
        </el-menu>
      </el-header>
      <el-main height="100px">
        <!-- 通过key值的变化去强制刷新后面的To-do-detail组件，刷新一次即可，因为一次以后路径和query就不再变化，也符合需求。 -->
        <router-view :key="$route.path + $route.query.action"></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // selectMenuIndex: ""
    };
  },
  methods: {
    // handleMenuSelect(key) {
    //   this.selectMenuIndex = key;
    // },
    activeMenu(path) {
      if (path.indexOf("/toDo") < 0) {
        return "1";
      }
      if (path.indexOf("/toDo") == 0) {
        return "2";
      }
    }
  },
  created() {
    // this.selectMenuIndex = 1;
  }
};
</script>

<style>
body {
  margin: 0;
}
.el-menu--horizontal > .el-menu-item.is-active {
  border-bottom: 0 !important;
}
.el-header {
  padding: 0 !important;
  position: fixed;
  width: 100%;
  z-index: 1001;
}
.el-menu-item {
  padding: 0 !important;
  transition: none !important;
}
.el-header,
.el-footer {
  background-color: #409eff;
  color: #333;
  text-align: center;
  line-height: 50px;
  height: 50px !important;
}
.el-main {
  /* background-color: #e9eef3; */
  color: #333;
  text-align: center;
  line-height: 100px;
  top: 100px;
  position: relative;
  z-index: 1000;
  padding: 0 20px !important;
}
body > .el-container {
  margin-bottom: 40px;
}
li.el-menu-item {
  width: 50%;
}
li a {
  text-decoration: none;
  font-size: 20px;
}
.el-menu-item.is-active {
  color: white;
}
.el-menu--horizontal > .el-menu-item {
  border-bottom: none !important;
}
.selectMenuFontWeight {
  font-weight: bold;
}
.el-icon-search {
  color: white;
}
</style>