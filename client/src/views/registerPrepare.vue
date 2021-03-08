<template>
    <div id="title">
        <label>注册新账户</label>
    </div>
    <div id="main">
        <el-form :model="form" :rules="rules" ref="form">
            <div id="information">
                <el-form-item prop="username">
                    <el-input v-model="form.username" placeholder="输入用户名" maxlength="12"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="form.password" placeholder="输入密码" show-password maxlength="16"></el-input>
                </el-form-item>
                <el-form-item prop="again">
                    <el-input v-model="form.again" placeholder="再次输入密码" show-password maxlength="16"></el-input>
                </el-form-item>
                <el-form-item prop="alias">
                    <el-input v-model="form.alias" placeholder="输入昵称" maxlength="7"></el-input>
                </el-form-item>
            </div>
            <div id="btns">
                <el-button type="primary" plain @click="postForm()">提交</el-button>
                <el-button type="primary" plain @click="goback()">返回</el-button>
            </div>
        </el-form>
    </div>
</template>

<script>
import { post } from '../access/http';
import Urls from '../access/urls';
export default {
    name: "Prepare",
    data(){
        let compareAgain = (rule, value, callback)=>{
            if(value == '')
            {
                callback(new Error("再次输入的密码不可为空!"));
            }
            else if(value !== this.form.password)
            {
                callback(new Error("两次输入的密码不一致!"));
            }
        }
        let checkPassword = (rule, value, callback)=>{
            if(value == '')
            {
                callback(new Error("密码不可为空"));
            }
            else if(value.length < 6)
            {
                callback(new Error("密码需要 6 位以上"));
            }
            else if(value.match("[^(!-~)]") != null)
            {
                callback(new Error("密码不能有中文或空格"));
            }
            else if(value.match("[0-9]") == null || value.match("[:-z]") == null)
            {
                callback(new Error("密码必须包含数字和字母或特殊字符"));
            }
        }
        let checkAlias = (rule, value, callback)=>{
            if(value == '')
            {
                callback(new Error("昵称不可为空"));
            }
            else if(value.match("[ -/,:-@,[-`,{-~]") != null)
            {
                callback(new Error("昵称不能使用特殊字符或空格"));
            }
        }
        return{
            form:{
                username:'',
                password:'',
                again:'',
                alias:''
            },
            rules:
            {
                username:[{ required: true, message: "用户名不可为空!", trigger: "blur" }],
                password:[{ validator: checkPassword, trigger: "blur" }],
                again:[{ validator: compareAgain, trigger: "blur" }],
                alias:[{ validator: checkAlias, trigger: "blur" }]
            },
        }
    },
    methods:{
        postForm(){
            this.$refs.form.validate();
            if( this.form.username != '' &&
                this.form.password != '' &&
                this.form.again != '' &&
                this.form.alias != '' &&
                this.form.password.length >= 6 &&
                this.form.password.match("[^(!-~)]") == null &&
                this.form.password.match("[0-9]") != null &&
                this.form.password.match("[:-z]") != null &&
                this.form.again == this.form.password &&
                this.form.alias.match("[ -/,:-@,[-`,{-~]") == null
                )
            {
                this.$parent.jump("Ongoing");
                post(Urls.POST_REGISTER_INFORMATION_INTERFACE,{ username: this.form.username, password: this.form.password, alias: this.form.alias })
                    .then(succeedResponse=>{        // response: boolean
                        if(succeedResponse.data == true)
                            this.$parent.jump("Succeed");
                        else
                            this.$parent.jump("Failed");
                    },
                    ()=>{
                        this.$parent.jump("Failed");
                    });
            }
        },
        goback(){
            this.$router.push("/login");
        }
    }
}
</script>

<style scoped>
#title{
    width: 50%;
    height: 50px;
    margin: 0 auto 0 auto;
    font-size: 20px;
    font-weight: bold;
    color: dodgerblue;
}
#main{
    width: 100%;
    margin: 0 auto 0 auto;
}
#information{
    width: 50%;
    margin: 0 auto 0 auto;
}
#btns{
    width: 100%;
}
</style>