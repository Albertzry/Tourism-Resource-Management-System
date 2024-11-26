<template>
  <div id="app">
    <div  class="login" v-show="$route.path=='/'||$route.path=='/login'">
      <router-link to="/login" v-show="$route.path=='/'">点击登录</router-link> 
    </div>
    <router-view v-wechat-title="$route.meta.title" ></router-view>
  </div>
</template>

<script>


export default {
  name: 'App',
  components: {

  }
}
</script>

<style scoped>
  p{
    background-color:rgba(255,255,255);
  }
  .router-link-active {
      text-decoration: none;
      color:white;
      display: block;
      margin: auto;
      font-size: xx-large;
      padding-top:300px;
      padding-bottom: 555px;
      background-color: rgba(0,0,0,0.5);
    }
    a {
      text-decoration: none;
      color: white;
      display: block;
      margin: auto;
      font-size: xx-large;
      padding-top:300px;
      padding-bottom: 555px;
      background-color: rgba(0,0,0,0.5);
    }
  #app{
    width: 100%;
    height: 100%;
  }
  .login{
    background-image: url('../public/1682001495958.png');
    background-repeat: no-repeat;
    background-size:cover; 
    width:100%;
    height:900px;
    text-align: center;
  }
</style>
