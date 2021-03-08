<template>
    <div class="top">
        <div class="title"><Title></Title></div>
        <div class="show">
            <el-scrollbar style="height:100%">
                <Show></Show>
            </el-scrollbar>
        </div>
        <div class="write" @click="clickWirter()">
            <el-scrollbar style="height:100%">
                <Write ref="writer"></Write>
            </el-scrollbar>
        </div>
        <div class="send">
            <Send></Send>
        </div>
    </div>
</template>

<script>
import Title from './parts/mainTitle';
import Show from './parts/mainShow';
import Write from './parts/mainWrite';
import Send from './parts/mainSend';
export default {
    name:"CheatMain",
    components:{ Title, Show, Write, Send },
    methods:{
        clickWirter() {
            document.getElementById("writerInput").focus();
        },
        clearWriter(){
            this.$refs.writer.clear();
        }
    }
}
</script>

<style scoped>
.top{
    background-color: whitesmoke;
    width: 100%;
    height: 100%;
    border-bottom-right-radius: 4px;
}
.title{
    display: flex;
    align-items: center;
    width: 100%;
    height: 40px;
    background-color:whitesmoke;
    
}
.show{
    overflow-y: auto;
    width: 100%;
    height: 300px;
    background-color:whitesmoke;
    border-top-style: solid;
    border-bottom-style: solid;
    border-color: rgb(190, 190, 190);
    border-width: 1px;
}
.write{
    overflow-y: auto;
    width: 100%;
    height: 110px;
    background-color: whitesmoke;
    cursor: text;
}
.send{
    display: flex;
    width: 95%;
    height: 45px;
    justify-content: flex-end;
    align-items: center;
}
</style>