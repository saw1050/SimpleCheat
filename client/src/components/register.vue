<template>
    <div id="root">
        <component :is="current"></component>
    </div>
</template>

<script>
import Prepare from '../views/registerPrepare';
import Ongoing from '../views/registerOngoing';
import Failed from '../views/registerFailed';
import Succeed from '../views/registerSucceed';
export default {
    name: "ComponentRegister",
    data(){
        return {
            current: "Prepare"
        }
    },
    methods:{
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
                case "Succeed":
                    this.current = "Succeed";
                    break;
                default:
                    break;
            }
        }
    },
    components: { Prepare, Ongoing, Failed, Succeed },
    beforeCreate:function(){
        document.getElementById('body').style.backgroundImage = "none";
    }
}
</script>

<style scoped>
#root{
    display: flex;
    width: 600px;
    height: 500px;
    flex-direction: column;
    position: absolute;
    left: 50%;
    top: 10%;
    margin-left: -300px;
    text-align: center;
}
</style>