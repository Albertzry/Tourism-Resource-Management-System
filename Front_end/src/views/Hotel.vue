
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
                    <el-menu-item index="/hotel" class="select">
                        <i class="el-icon-school"></i>
                        <span slot="title">酒店管理</span>
                    </el-menu-item>
                    <el-menu-item index="/parking">
                        <i class="el-icon-truck"></i>
                        <span slot="title">停车场管理</span>
                    </el-menu-item>
                    <el-menu-item index="/guider">
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
                    <el-menu-item index="/home" >
                        <i class="el-icon-s-home"></i>
                        <span slot="title" >首页</span>
                    </el-menu-item>
                    <el-menu-item index="/console">
                        <i class="el-icon-set-up"></i>
                        <span slot="title">控制台</span>
                    </el-menu-item>
                    <el-menu-item index="/home">
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
                        <el-button size="mini" type="primary" @click="resortByCapacity">按可容纳人数排序</el-button>
                        <el-button size="mini" type="primary" @click="resortByLevel">按等级排序</el-button>
                        <input type="text" class="search" placeholder="请输入要查询的酒店编号，格式为id:1">
                        <el-button size="mini" type="primary" @click="search">搜索</el-button>
                        <el-dialog :title="title" :visible.sync="dialogFormVisible" width="30%">
                            <el-form :model="form" :rules="rules" ref="form">
                                <el-form-item label="id:" prop="id">
                                    <el-input v-model="form.id" placeholder="请输入酒店编号" style="width: 80%"></el-input>
                                </el-form-item>
                                <el-form-item label="酒店名称:" prop="name">
                                    <el-input v-model="form.name" placeholder="请输入酒店名称" style="width:80%"></el-input>
                                </el-form-item>
                                <el-form-item label="可容纳人数:" prop="capacity">
                                    <el-input v-model.number="form.capacity" placeholder="请输入酒店可容纳人数" style="width:80%"></el-input>
                                </el-form-item>
                                <el-form-item label="等级:" prop="level">
                                    <el-select v-model.number="form.level" placeholder="请选择等级" style="width:80%">
                                        <el-option label="1" value="1"></el-option>
                                        <el-option label="2" value="2"></el-option>
                                        <el-option label="3" value="3"></el-option>
                                        <el-option label="4" value="4"></el-option>
                                        <el-option label="5" value="5"></el-option>
                                    </el-select>
                                </el-form-item>
                                <el-form-item label="联系方式:" prop="phone">
                                    <el-input v-model="form.phone" placeholder="请输入联系方式（手机号码）" style="width:80%"></el-input>
                                </el-form-item>
                                <el-form-item label="邮箱:" prop="email">
                                    <el-input v-model="form.email" placeholder="请输入邮箱" style="width:80%"></el-input>
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
                                label="酒店编号"
                                width="120"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                property="name"
                                label="酒店名称"
                                width="120"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                property="capacity"
                                label="可容纳人数"
                                width="120"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                property="level"
                                label="等级"
                                width="120"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                property="phone"
                                label="联系方式"
                                align="center">
                        </el-table-column>
                        <el-table-column
                                property="email"
                                label="邮箱"
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
      name: "index",
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
            name: [{required: true, message: '请输入酒店名称', trigger: 'blur'}],
            capacity: [{required: true, message: '请输入可容纳人数', trigger: 'blur'},
              {type: 'number', message: '可容纳人数必须为数字值', trigger: 'blur'}],
            level: [{required: true, message: '请选择性别', trigger: 'change'},
              {type:'number',message:'等级为1-5之间',trigger:'change'}],
            phone: [{required: true, message: '请输入联系方式（手机号码）', trigger: 'blur'}],
            email:[{required: true, message: '请输入邮箱地址', trigger: 'blur'}],
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
            capacity: null,
            level: null,
            phone: null,
            email:null
          }
        },
        created(){
          this.insertOredit=0;
        },
        // 增
        add() {
          this.reset()
          this.dialogFormVisible = true
          this.title = "新增酒店数据"
          this.insertOredit=1
        },
        // 删
        remove(index, row) {
          console.log(row.id)
          this.$axios({
            method: 'post',
            url: 'http://localhost:9090/hotel/delete/' + row.id,
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
          this.title = "修改酒店数据"
          this.insertOredit=0
        },

        //查
        getList() {
          this.$axios({
            method: 'get',
            url: 'http://localhost:9090/hotel/info',
          }).then((response) => {
            this.tableData = response.data
            console.log(this.tableData);
          }).catch((error) => {
          })
        },
        //更改排序
        resortByCapacity(){
          this.$axios({
            method:'get',
            url:'http://localhost:9090/hotel/info/capacitySort'
          }).then((response)=>{
            this.tableData=response.data
            console.log(this.tableData);
          }).catch((error)=>{
            console.log(error.message);
          })
        },
        resortByLevel(){
          this.$axios({
            method:'get',
            url:'http://localhost:9090/hotel/info/levelSort'
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
              url:'http://localhost:9090/hotel/search/'+id,
            }).then((response=>{
              this.tableData = response.data;
              console.log(response.data);
            }))
          }
          if(stringStr==''){
            this.$axios({
              method: 'get',
              url: 'http://localhost:9090/hotel/info',
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
                  url: 'http://localhost:9090/hotel/add',
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
                  url: 'http://localhost:9090/hotel/edit',
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
      text-align: center;
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

    .select{
    background-color: rgba(255,0,0,0.5);
    }

    .aside{
      background-color: #304156;
    }

    .search {
      width: calc(100% - 700px);
      display: inline-block;
      margin-right:20px;
      margin-left: 20px;
    }
    .el-footer{
      text-align: center;
    }
  </style>
