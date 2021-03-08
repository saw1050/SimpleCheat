<template>
    <div>
        <strong>Failed!</strong>
        <el-button type="primary" @click="goback">返回</el-button>
    </div>
</template>

<script>
export default {
    name:"Failed",
    methods:{
        goback(){
            this.$parent.jump("Prepare");
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
    color: crimson;
}
</style>