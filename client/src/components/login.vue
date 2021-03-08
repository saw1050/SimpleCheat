<template>
    <div id="loginDiv">
        <div id="centerRectangular">
            <component :is="current"></component>
        </div>
    </div>
</template>

<script>
import Prepare from '../views/loginPrepare';
import Ongoing from '../views/loginOngoing';
import Failed from '../views/loginFailed';
import Urls from '../access/urls';
import {get } from '../access/http';
import { getCookie } from '../utils/cookier';
import {mapMutations} from 'vuex';

export default {
    name:"ComponentLogin",
    data(){
        return{
            current:"Prepare"
        }
    },
    methods:{
        ...mapMutations(['setToken']),
        jump(view){
            switch (view) {
                case "Prepare":
                    this.current = "Prepare";
                    break;
                case "Ongoing":
                    this.current = "Ongoing";
                    break;
                case "Failed":
                    this.current = "Failed";
                    break;
                default:
                    break;
            }
        }
    },
    mounted() {
        let e = document.getElementById("loginDiv");
        e.hidden = true;
        let token = getCookie("token");
        if (token != null)
            get(Urls.CHECK_TOKEN_PREFIX + `${token}`)
            .then(
                succeedResponse => { // response: boolean
                    if (succeedResponse.data == true) {
                        this.setToken(token);
                        document.location.replace("/cheat");
                    } else {
                        e.hidden = false;
                        document.getElementById("body").style.backgroundImage = "url("+require("../assets/background.jpg")+")";
                    }
                },
                ()=>{
                    e.hidden = false;
                    document.getElementById("body").style.backgroundImage = "url("+require("../assets/background.jpg")+")";
                }
            );
        else {
            e.hidden = false;
            document.getElementById("body").style.backgroundImage = "url("+require("../assets/background.jpg")+")";
        }
    },
    components:{ Prepare,Ongoing,Failed }
}
</script>

<style scoped>
#loginDiv{
    width: 100%;
    height: 700px;
}
#centerRectangular{
    position: absolute;
    left: 50%;
    top: 50%;
    width: 400px;
    height: 300px;
    margin-left: -200px;
    margin-top: -300px;
    background-color: rgb(208, 237, 253);
    border-radius: 5px;
    
}

</style>