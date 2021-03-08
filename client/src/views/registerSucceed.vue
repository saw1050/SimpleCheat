<template>
    <div>
        <strong>Succeed!</strong>
        <el-button type="primary" @click="goback">去登录</el-button>
    </div>
</template>

<script>
export default {
    name:"Succeed",
    methods:{
        goback(){
            this.$router.push("/login");
        }
    }
}
</script>

<style scoped>
div{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    width: 20%;
    height: 120px;
    margin: 0 auto 0 auto;
}
strong{
    color:seagreen;
}
</style>