<template>
    <div class="top">
        <el-scrollbar style="height:100%">
            <div class="cells">
                <table style="width: 100%; border-spacing: 0px;">
                    <tr class="dial" v-for="(i,index) in friends" :key="i" @click="select($event)"><td>
                        <Dialogue :guy="friends[index]"></Dialogue>
                    </td></tr>
                    <tr><td>
                        <el-button icon="el-icon-plus" style="background-color: rgb(190, 190, 190); border-style: none; font-weight: 500; width: 100%" @click="toAddFriend">
                            添加新朋友
                        </el-button>
                    </td></tr>
                </table>
            </div>
        </el-scrollbar>
    </div>
</template>

<script>
import Dialogue from './parts/dialogue';
import { mapState } from 'vuex';
export default {
    name:"CheatAside",
    components:{ Dialogue },
    data(){
        return{
            current:null,
            maps:[],
        }
    },
    computed:{
        ...mapState(["friends"]),
    },
    methods:{
        setOverColor(e){
            e.onmouseover = () => { e.style.backgroundColor = "rgb(175, 175, 175)"; }
        },
        setOutColor(e){
            e.onmouseout = () => { e.style.backgroundColor = "rgb(190, 190, 190)"; }
        },
        select(e){
            if(this.current != null)
            {
                this.current.style.backgroundColor = "rgb(190, 190, 190)";
                this.setOverColor(this.current);
                this.setOutColor(this.current);
            }
            this.current = e.currentTarget;
            this.current.style.backgroundColor = "rgb(160, 160, 160)";
            this.current.onmouseover = null;
            this.current.onmouseout = null;
        },
        toMain(){
            this.$parent.$parent.$parent.toMain();
        },
        toDefaultMain(){
            this.$parent.$parent.$parent.toDefaultMain();
        },
        toAddFriend(){
            if(this.current != null)
            {
                this.current.style.backgroundColor = "rgb(190, 190, 190)";
                this.setOverColor(this.current);
                this.setOutColor(this.current);
            }
            this.$parent.$parent.$parent.toAddFriend();
        }
    },
    mounted:function(){
        let e = document.getElementsByClassName("dial");
        for(let i=0;i<this.friends.length;i++){
            e[i].onmouseover = () => { e[i].style.backgroundColor = "rgb(175, 175, 175)"; }
            e[i].onmouseout = () => { e[i].style.backgroundColor = "rgb(190, 190, 190)"; }
        }
    },
}
</script>

<style scoped>
.top{
    background-color: rgb(190, 190, 190);
    width: 100%;
    height: 100%;
    border-bottom-left-radius: 4px;
}
.cell{
    border: none;
    border-bottom-left-radius: 4px;
}
tr{
    background-color: rgb(190, 190, 190);
}
td{
    width: 100%;
    height: 60px;
}
</style>