<template>
    <div id = "root">
        <div id = "in" style="width:100%">
            <el-input id="writerInput" type="textarea" rows="4" autosize resize="none" v-model="message" @input="update"></el-input>
        </div>
    </div>
</template>

<script>
import { mapMutations } from 'vuex';
export default {
    name:"Write",
    data(){
        return {
            message:''
        }
    },
    methods:{
        ...mapMutations(["fillInput"]),
        update(){
            this.fillInput(this.message);
        },
        clear(){
            this.message = '';
            document.getElementById('writerInput').focus();
        },
    }
}
</script>

<style>
#in .el-textarea__inner{
    border-style: none;
    border-width: 0;
    border-radius: 0;
    background-color: whitesmoke;
    font-family: "黑体";
    font-size: 16px;
    font-weight: 500;
}
</style>