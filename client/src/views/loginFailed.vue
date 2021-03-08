<template>
    <div class="out">
        <div class="in">
            <label>{{loginResult}}</label>
            <el-button id="confirm" type="primary" @click="goback()">重新登录</el-button>
        </div>
    </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
    name:"Failed",
    data(){
        return {}
    },
    methods:{
        goback(){
            this.$parent.jump("Prepare");
        }
    },
    computed:{
        ...mapState(['loginResult'])
    }
}
</script>

<style scoped>
.out{
    display: flex;
    height: 300px;
    flex-direction: column;
    text-align: center;
    justify-content: center;
}
.in{
    display: flex;
    flex-direction: column;
    width: 100%;
    height: 150px;
    justify-content: space-between;
    margin: 100px auto auto auto;
}
label{
    color: rgb(192, 0, 0);
    font-size: 18px;
    font-weight: bold;
}
#confirm{
    width: 33%;
    margin: auto auto auto auto;
}
</style>