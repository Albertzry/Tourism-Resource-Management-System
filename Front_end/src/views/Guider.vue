<template>
    <el-container>
        <!-- width的宽度跟collapse一样动态控制 -->
        <el-aside width="collapse" class="aside">
            <div class="logo" v-show="open"><h3><i class="el-icon-eleme"></i>旅游行业管理和运行调度系统</h3></div>
            <div class="logo" v-show="close"><h3><i class="el-icon-eleme"></i></h3></div>
            <!-- :collapse="isCollapse"  class="el-menu-vertical" 动态控制导航菜单的收起与展开  router：让index作为 path 进行路由跳转 -->
            <el-menu default-active="$route.path"
                     router
                     :default-openeds="openeds"
                     :collapse="isCollapse"
                     class="el-menu-vertical">
                <el-submenu index="1">
            <!-- 一级标题 -->
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span slot="title">后台管理</span>
            </template>
            <!--  二级标题 -->
            <el-menu-item index="/tourist_attraction">
              <i class="el-icon-sunset"></i>
              <span slot="title">景区管理</span>
            </el-menu-item>
            <el-menu-item index="/travel_agency">
              <i class="el-icon-s-cooperation"></i>
              <span slot="title">旅行社管理</span>
            </el-menu-item>
              <el-menu-item index="/hotel">
                <i class="el-icon-school"></i>
                <span slot="title">酒店管理</span>
              </el-menu-item>
              <el-menu-item index="/parking">
                <i class="el-icon-truck"></i>
                <span slot="title">停车场管理</span>
              </el-menu-item>
            <el-menu-item index="/guider"  class="select">
              <i class="el-icon-discover"></i>
              <span slot="title">导游管理</span>
            </el-menu-item>
            <el-menu-item index="/feedback">
              <i class="el-icon-message"></i>
              <span slot="title">游客反馈</span>
            </el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <!-- 新一级标题 -->
            <template slot="title">
              <i class="el-icon-user-solid"></i>
              <span slot="title">我的</span>
            </template>
            <!--  二级标题 -->
            <el-menu-item index="/home">
              <i class="el-icon-s-home"></i>
              <span slot="title" >首页</span>
            </el-menu-item>
            <el-menu-item index="/console">
              <i class="el-icon-set-up"></i>
              <span slot="title">控制台</span>
            </el-menu-item>
            <el-menu-item index="/mine">
              <i class="el-icon-user"></i>
              <span slot="title">个人中心</span>
            </el-menu-item>
            <el-menu-item index="/">
              <i class="el-icon-remove"></i>
              <span slot="title">登出</span>
            </el-menu-item>

          </el-submenu>
        </el-menu>


        </el-aside>

        <el-container>
            <el-header>
                <div class="trigger" @click="isShow">
                    <!-- 点击展开收起导航和切换对应图标 -->
                    <i class="el-icon-s-fold" v-show="open"></i>
                    <i class="el-icon-s-unfold" v-show="close"></i>

                </div>

            </el-header>
            <el-main>
                <el-card class="box-card">
                    <!-- Dialog 对话框 弹出新增和修改表单 -->
                    <el-row>
                        <el-button size="mini" type="primary" @click="add">新增</el-button>
                        <el-button size="mini" type="primary" @click="resortByAge">按年龄排序</el-button>
                        <el-button size="mini" type="primary" @click="resortByWorkExp">按从业时间排序</el-button>
                        <input type="text" class="search" placeholder="请输入要查询的导游编号或姓名或联系方式，格式为id:1或name:Q或phone:XXXXX">
                        <el-button size="mini" type="primary" @click="search">搜索</el-button>
                        <el-dialog :title="title" :visible.sync="dialogFormVisible" width="30%">
                            <el-form :model="form" :rules="rules" ref="form">
                                <el-form-item label="id:" prop="id">
                                    <el-input v-model="form.id" placeholder="请输入导游编号" style="width: 80%"></el-input>
                                </el-form-item>
                                <el-form-item label="姓名:" prop="name">
                                    <el-input v-model="form.name" placeholder="请输入姓名" style="width:80%"></el-input>
                                </el-form-item>
                                <el-form-item label="年龄:" prop="age">
                                    <el-input v-model.number="form.age" placeholder="请输入年龄" style="width:80%"></el-input>
                                </el-form-item>
                                <el-form-item label="性别:" prop="sex">
                                    <el-select v-model="form.sex" placeholder="请选择性别" style="width:80%">
                                        <el-option label="男" value="男"></el-option>
                                        <el-option label="女" value="女"></el-option>
                                    </el-select>
                                </el-form-item>
                                <el-form-item label="联系方式:" prop="phone">
                                    <el-input v-model="form.phone" placeholder="请输入联系方式（手机号码）" style="width:80%"></el-input>
                                </el-form-item>
                                <el-form-item label="从业时间:" prop="work_exp">
                                    <el-input v-model.number="form.work_exp" placeholder="请输入从业时间" style="width:80%"></el-input>
                                </el-form-item>
                            </el-form>
                            <div slot="footer" class="dialog-footer">
                                <el-button @click="dialogFormVisible = false">取 消</el-button>
                                <el-button type="primary" @click="submit()">提 交</el-button>
                            </div>
                        </el-dialog>
                    </el-row>

                    <!-- 表格 -->
                    <el-table
                            ref="singleTable"
                            :data="tableData"
                            style="width: 100%">
                        <el-table-column
                                type="selection"
                                width="55">
                        </el-table-column>
                        <el-table-column
                                property="id"
                                label="id"
                                width="120"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                property="name"
                                label="姓名"
                                width="120"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                property="age"
                                label="年龄"
                                width="120"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                property="sex"
                                label="性别"
                                width="120"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                property="phone"
                                label="联系方式"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                property="work_exp"
                                label="从业时间"
                                width="120"
                                align="center">
                        </el-table-column>
                        <el-table-column label="操作" align="center">
                            <template slot-scope="scope">
                                <el-button
                                        size="mini"
                                        @click="edit(scope.$index, scope.row)">编辑
                                </el-button>
                                <el-button
                                        size="mini"
                                        type="danger"
                                        @click="remove(scope.$index, scope.row)">删除
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-card>

                <router-view></router-view>
            </el-main>
            <el-footer>欢迎来到旅行行业管理与调度系统！</el-footer>
        </el-container>
    </el-container>

</template>

<script>
    export default {
      name: "Guider1",
      data() {
        return {
          openeds: ["1"],
          isCollapse: false, //导航栏默认为展开
          close: false, //第二个图标默认隐藏
          open: true, //默认显示第一个图标
          title: '',
          currentRow: null,
          dialogFormVisible: false,
          form: {},
          tableData: [],
          rules: {
            name: [{required: true, message: '请输入姓名', trigger: 'blur'}],
            age: [{required: true, message: '请输入年龄', trigger: 'blur'},
              {type: 'number', message: '年龄必须为数字值', trigger: 'blur'},
              {pattern: /^(0|[1-9]\d?|100)$/, message: '范围在0-100', trigger: 'blur'}],
            sex: [{required: true, message: '请选择性别', trigger: 'change'}],
            phone: [{required: true, message: '请输入联系方式（手机号码）', trigger: 'blur'}],
            work_exp:[{required: true, message: '请输入年龄', trigger: 'blur'},
              {type: 'number', message: '年龄必须为数字值', trigger: 'blur'},
              {pattern: /^(0|[1-9]\d?|100)$/, message: '范围在0-100', trigger: 'blur'}],
          }
        }
      },
      methods: {
        isShow() {
          this.isCollapse = !this.isCollapse;
          this.open = !this.open;
          this.close = !this.close;
        },
        // 表单重置初始化
        reset() {
          this.form = {
            id: null,
            name: null,
            age: null,
            sex: null,
            phone: null,
            work_exp:null
          }
        },
        created(){
          this.insertOredit=0;
        },
        // 增
        add() {
          this.reset()
          this.dialogFormVisible = true
          this.title = "新增导游数据"
          this.insertOredit=1
        },
        // 删
        remove(index, row) {
          console.log(row.id)
          this.$axios({
            method: 'post',
            url: 'http://localhost:9090/guider/delete/' + row.id,
          }).then((response) => {
            this.$message({
              message: '删除成功!',
              type: 'success'
            });
            this.getList();
          }).catch((error) => {
          })
        },

        // 改
        edit(index, row) {
          this.reset()
          this.form = JSON.parse(JSON.stringify(row));
          this.dialogFormVisible = true
          this.title = "修改导游数据"
          this.insertOredit=0
        },

        //查
        getList() {
          this.$axios({
            method: 'get',
            url: 'http://localhost:9090/guider/info',
          }).then((response) => {
            this.tableData = response.data;
            console.log(this.tableData);
          }).catch((error) => {
          })
        },
        //更改排序
        resortByAge(){
          this.$axios({
            method:'get',
            url:'http://localhost:9090/guider/info/sortByAge'
          }).then((response)=>{
            this.tableData=response.data
            console.log(this.tableData);
          }).catch((error)=>{
            console.log(error.message);
          })
        },
        resortByWorkExp(){
          this.$axios({
            method:'get',
            url:'http://localhost:9090/guider/info/sortByWorkExp'
          }).then((response)=>{
            this.tableData=response.data
            console.log(this.tableData);
          }).catch((error)=>{
            console.log(error.message);
          })
        },
        //查一个
        search(){
          var searchContent=document.querySelector(".search").value;
          console.log(searchContent);
          let stringStr=searchContent.split(":");
          console.log(stringStr);
          if(stringStr[0]=='id'){
            let id= parseInt(stringStr[1]);
            console.log(id);
            this.$axios({
              method:'get',
              url:'http://localhost:9090/guider/info/searchById/'+id,
            }).then((response=>{
              this.tableData=response.data;
              console.log(response.data);
            }))
          }
          if(stringStr[0]=='name'){
            let name=stringStr[1];
            this.$axios({
              method:'get',
              url:'http://localhost:9090/guider/info/searchByName/'+name,
            }).then((response=>{
              this.tableData=response.data;
              console.log(response.data);
            }))
          }
          if(stringStr[0]=='phone'){
            let phone=stringStr[1];
            this.$axios({
              method:'get',
              url:'http://localhost:9090/guider/info/searchByPhone/'+phone,
            }).then((response=>{
              this.tableData=response.data;
              console.log(response.data);
            }))
          }
          if(stringStr==''){
            this.$axios({
              method: 'get',
              url: 'http://localhost:9090/guider/info',
            }).then((response)=>{
            this.tableData=response.data;
            console.log(this.tableData);
          }).catch((error) => {})
          }
        },
        //提交按钮
        submit() {
          this.$refs['form'].validate((valid) => {
            if (valid) {
              if (this.insertOredit==1) {
                this.$axios({
                  method: 'post',
                  data: this.form,
                  url: 'http://localhost:9090/guider/insert',
                }).then((response) => {
                  this.$message({
                    message: '新增成功!',
                    type: 'success'
                  });
                  this.dialogFormVisible = false
                  this.getList();
                }).catch((error) => {
                })
              } else {
                this.$axios({
                  method: 'post',
                  data: this.form,
                  url: 'http://localhost:9090/guider/update',
                }).then((response) => {
                  this.$message({
                    message: '修改成功!',
                    type: 'success'
                  });
                  this.getList();
                  this.dialogFormVisible = false
                }).catch((error) => {
                })
              }
            } else {
              return false;
            }
          })
        }
      },
      mounted() {
        this.getList();
      }
    }
  </script>

<style scoped>
    .el-header, .el-footer {
      background-color: #B3C0D1;
      color: #333;
      line-height: 60px;
      height: 100%;
      padding: 0 !important;
    }

    .el-aside {
      background-color: #D3DCE6;
      color: #333;
      height: 100vh;
    }

    .el-main {
      background-color: #E9EEF3;
      color: #333;
    }

    body > .el-container {
      margin-bottom: 40px;
    }

    .logo {
      height: 160px;
      line-height: 160px;
      background-color: #304156;
      text-align:center;
      color: #fff;
    }

    .logo h3 {
      margin: 0;
      height: 60px;
    }

    .el-menu {
      border-right-width: 0px;
    }

    .el-menu-vertical:not(.el-menu--collapse) {
      width: 300px;
    }

    .trigger {
      height: 60px;
      display: flex;
      align-items: center;
      justify-content: center;
      cursor: pointer;
      width: 54px;
    }

    .trigger i {
      font-size: 20px;
    }

    .trigger:hover {
      background-color: rgb(203, 215, 230);
    }

    .search {
      width: calc(100% - 450px);
      display: inline-block;
      margin-right:20px;
      margin-left: 20px;
    }

    .aside{
     background-color: #304156;
     color: #fff;
    }

    .select{
    background-color: rgba(255,0,0,0.5);
    }
    .el-footer{
      text-align: center;
    }
  </style>
