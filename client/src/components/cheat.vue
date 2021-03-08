<template>
    <div id="root">
        <el-container>
            <el-header style="padding:0;">
                <component :is="header"></component>
            </el-header>
        </el-container>
        <el-container style="height:500px; width:100%">
            <el-aside style="width:25%">
                <component :is="aside"></component>
            </el-aside>
            <el-main style="padding:0">
                <component :is="main"></component>
            </el-main>
        </el-container>
    </div>
</template>

<script>
import CheatHeader from '../views/cheatHeader';
import CheatAside from '../views/cheatAside';
import CheatMain from '../views/cheatMain';
import CheatMainDefault from '../views/cheatMainDefault';
import CheatMainAddFriend from '../views/cheatMainAddFriend';
import { requestFriendList, requestOfflineMessages } from '../access/friends';
import { mapState,mapMutations } from 'vuex';
import { get } from '../access/http';
import Urls from '../access/urls';
export default {
    name:"ComponentCheat",
    components:{ CheatHeader, CheatAside, CheatMain, CheatMainDefault, CheatMainAddFriend },
    data(){
        return {
            limit:true,
            header: "CheatHeader",
            aside: "CheatAside",
            main: "CheatMainDefault",
        }
    },
    computed:{
        ...mapState(['token']),
    },
    methods:{
        ...mapMutations(["setInformation"]),
        toMain(){
            this.main = "CheatMain";
        },
        toDefaultMain(){
            this.main = "CheatMainDefault";
        },
        toAddFriend(){
            this.main = "CheatMainAddFriend";
        }
    },
    mounted(){
        get(Urls.GET_SELF_INFORMATION_PREFIX + this.token)
        .then(
            response => {
                if (response.data.result == true) {
                    this.setInformation(response.data.information);
                    requestFriendList(this.token);
                    requestOfflineMessages(this.token);
                }
            }
        )
    }
}
</script>

<style scoped>
#root{
    position: absolute;
    width: 700px;
    height: 550px;
    top: 10%;
    left: 50%;
    margin-left: -350px;
}
</style>