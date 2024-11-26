<template>
  <div class="login-container" id="app">
    <el-form :model="ruleForm2" :rules="rules2"
             status-icon
             ref="ruleForm2"
             label-position="left"
             label-width="0px"
             class="demo-ruleForm login-page">
      <h3 class="title">系统登录</h3>
      <el-form-item prop="username">
        <el-input type="text"
                  v-model="ruleForm2.username"
                  auto-complete="off"
                  placeholder="用户名"
        ></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password"
                  v-model="ruleForm2.password"
                  auto-complete="off"
                  placeholder="密码"
        ></el-input>
      </el-form-item>
      <el-checkbox
        v-model="checked"
        class="rememberme"
      >记住密码
      </el-checkbox>
      <el-form-item style="width:100%;">
        <el-button class="register" type="primary" style="width:40%;" @click="register" :loading="logining">注册</el-button>
        <el-button type="primary" style="width:40%;" @click="handleSubmit" :loading="logining">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
 
<script>
import jsCookie from 'js-cookie';
  export default {
    name: "login",
    Myusername(){
      username:'';
    },
    data(){
      return {
        logining: false,
        ruleForm2: {
          username: '',
          password: '',
        },
        rules2: {
          username: [{required: true, message: 'please enter your account', trigger: 'blur'}],
          password: [{required: true, message: 'enter your password', trigger: 'blur'}]
        },
        checked: false
      }
    },
    methods: {
      handleSubmit(event){
        this.$refs.ruleForm2.validate((valid) => {
          if(valid){
            this.logining = true;
            this.$axios({
              method:'get',
              url:'http://localhost:9090/login/user/'+this.ruleForm2.username,
            }).then((response=>{
                console.log(response.data);
                if(response.data.password==this.ruleForm2.password){
                  this.logining=false;
                  sessionStorage.setItem('user', this.ruleForm2.username);
                  jsCookie.set('username',this.ruleForm2.username);
                  this.$router.push({path: '/home'});
                }else{
                  this.logining = false;
                  this.$alert('username or password wrong!', 'info', {
                  confirmButtonText: 'ok'})
                }
            })).catch((error=>{
              this.logining=false;
              this.$alert('username or password wrong!','info',{
                confirmButtonText:'ok'
              })
            }))
          }else{
            console.log('error submit!');
            return false;
          }
        })
      },
      register(){
        this.$refs.ruleForm2.validate((valid) => {
          if(valid){
            this.logining = true;
            this.$axios({
              method:'post',
              data:this.ruleForm2,
              url:'http://localhost:9090/login/insert',
            }).then((response=>{
                this.$alert("注册成功",'info',{
                  confirmButtonText:'ok'
                })
                console.log(response.data);
                this.logining=false;
                sessionStorage.setItem('user', this.ruleForm2.username);
            })).catch((error=>{
              this.logining=false;
              this.$alert('注册失败!','info',{
                confirmButtonText:'ok'
              })
            }))
          }else{
            console.log('error submit!');
            return false;
          }
        })
      }
    }
  }
</script>
 
<style scoped>
  .login-container {
    width: 100%;
    height: 100%;
    background-image: url("../../public/1682001495958.png");
    background-repeat: no-repeat;
    background-size: cover;
  }
  .login-page {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    width: 350px;
    padding: 35px 35px 15px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
    margin: 0;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }
 
  label.el-checkbox.rememberme {
    margin: 0px 0px 15px;
    text-align: left;
  }
  .register{
    margin-right: 60px;
  }
  .title{
    text-align: center;
  }
</style>
 