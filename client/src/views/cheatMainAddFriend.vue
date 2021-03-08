<template>
    <div class="top">
        <strong>添加新好友</strong>
        <el-form v-model="form">
            <div class="inputAndButton">
                <el-input v-model="form.keyword" prefix-icon="el-icon-search" size="small"></el-input>
                <el-button type="primary" style="margin-left: 10px" size="small" @click="search">查找</el-button>
            </div>
        </el-form>
        <div class="main">
            <div class="tags">
                <div class="captain" v-if="matchTotal > 0">
                    <div style="width: 40px"></div>
                    <label style="font-size: 8px; width: 40%; text-align: center; font-weight: 800">账户名</label>
                    <label style="font-size: 8px; width: 25%; text-align: center; font-weight: 800">昵称</label>
                    <div style="width: 60px"></div>
                </div>
                <div class="tag" v-for="i in 5" :key="i">
                    <img src="../assets/20201228122504.jpg" width="40" height="40">
                    <label style="width: 40%; text-align: center; font-size: 6px">啊手动阀手动阀手动阀阀手</label>
                    <label style="width: 25%; text-align: center; font-size: 6px">啊手动阀手动阀</label>
                    <el-button size="mini" type="primary" plain>添加</el-button>
                </div>
            </div>
            <el-pagination v-if="matchTotal > 0" small layout="prev, pager, next" :page-size="5" :pager-count="5" :total="matchTotal"></el-pagination>
        </div>
    </div>
</template>

<script>
export default {
    name: "CheatMainAddFriend",
    data(){
        return {
            form:{ keyword:'' },
            matchTotal: 0
        }
    },
    methods:{
        search(){
            this.matchTotal++;
        }
    }
}
</script>

<style scoped>
.top{
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
    width: 100%;
    height: 100%;
    background-color:whitesmoke;
}
strong{
    color:rgb(150, 150, 150);
}
.inputAndButton{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
.main{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    height: 60%;
    width: 80%;
    margin: 15px auto 40px auto;
}
.tags{
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
    height: 80%
}
.captain{
    display: flex;
    flex-direction: row;
    justify-content: center;
    width: 100%;
    height: 20px;
}
.tag{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: center;
    width: 95%;
    height: 45px;
    /* background-color: burlywood; */
    border-bottom-style: solid;
    border-color: rgb(190, 190, 190);
    border-width: 1px;
}
</style>

<style>
.el-pagination button:disabled{
    cursor: default!important;
}
</style>