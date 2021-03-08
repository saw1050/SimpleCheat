<template>
    <div>
        <el-form id="loginForm" :model="form" :rules="rules" ref="form">
                <label>用户登录</label>
                <el-form-item prop="username">
                    <el-input v-model="form.username" placeholder="输入用户名"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="form.password" show-password placeholder="输入密码"></el-input>
                </el-form-item>
                <div id="btnDiv">
                    <el-button id="loginBtn" type="primary" @click="submit()">登录</el-button>
                    <a href="/register" style="font-size: 12px; width: 60px; margin: auto auto auto auto">注册新用户</a>
                </div>
            </el-form>
    </div>
</template>

<script>
import { post } from '../access/http';
import { setCookie } from '../utils/cookier';
import { mapMutations } from 'vuex';
import Urls from '../access/urls';

export default {
    name:"Prepare",
    data(){
        return {
            form:{
                username:'',
                password:''
            },
            rules:{
                username:[{required:true, message:"用户名不可为空!", trigger:"blur"}],
                password:[{required:true, message:"密码不可为空!", trigger:"blur"}],
            }
            
        }
    },
    computed:{

    },
    methods:{
        ...mapMutations(['setLoginResult','setToken']),
        submit(){
            this.$parent.jump("Ongoing");
            post(Urls.POST_LOGIN_INFORMATION_INTERFACE,this.form).then(response=>{
                /**
                 * response.data
                 * {
                 *      result: "succeed" | "error_pwd" | "error_usr"
                 *      token: "xxxx.xxxx.xxxx"
                 * }
                 */
                switch (response.data.result) {
                    case "succeed":
                        setCookie('token',response.data.token,{expire:60});
                        this.setToken(response.data.token);
                        document.location.replace("/cheat");
                        break;
                    case "error_pwd":
                        this.setLoginResult("密码错误!");
                        this.$parent.jump("Failed");
                        break;
                    case "error_usr":
                        this.setLoginResult("用户名错误!");
                        this.$parent.jump("Failed");
                        break;
                    default:
                        this.setLoginResult("未知错误!");
                        this.$parent.jump("Failed");
                        break;
                }
            },
            ()=>{
                this.setLoginResult("无法连接服务器!")
                this.$parent.jump("Failed");
            });
        }
    },
    
}
</script>

<style scoped>
label{
    text-align: center;
    margin-bottom: 5%;
    font-weight: bold;
    font-size: 20px;
    color: rgb(85, 170, 255);
}
#loginForm{
    display: flex;
    width: 80%;
    height: 80%;
    margin: 10% auto auto auto;
    flex-direction: column;
}
#btnDiv{
    display: flex;
    flex-direction: column;
    width: 100%;
    height: 70px;
    margin: auto auto auto auto;
    text-align: center;
}
#loginBtn{
    width: 33%;
    margin: auto auto auto auto;
}
</style>

