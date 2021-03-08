<template>
    <div id = "root" @click="loadShow">
        <div id = "snap"><img src="../../assets/20201228122504.jpg" width="40" height="40"></div>
        <div id = "name"><label class="inside">{{guy.alias==null?guy.name:guy.alias}}</label></div>
    </div>
</template>


<script>
import { mapMutations } from 'vuex';
export default {
    name: "Dialogue",
    props:["guy"],
    data(){
        return{
            
        }
    },
    methods:{
        ...mapMutations(["setSession"]),
        loadShow(){
            this.setSession(this.guy);
            this.$parent.$parent.toMain();
        }
    }
}
</script>


<style scoped>
#root{
    display: flex;
    width: 100%;
    height: 100%;
    flex-direction: row;
    justify-content: space-around;
}
#snap{
    display: flex;
    justify-content: center;
    align-items: center;
    width: 40%;
}
#name{
    display: flex;
    justify-content:flex-start;
    align-items: center;
    width: 60%;
}
</style>