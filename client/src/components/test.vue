<template>
    <div>
        <el-button @click="test">测试</el-button>
    </div>
</template>

<script>
import {post} from '../access/http';
export default {
    methods:{
        test(){
            post("http://localhost:12219/test",{list:[1,2,3,4,5]}).then(
                response=>{console.log(response.data.first);},
                ()=>{console.log("no");}
            )
        }
    }
}
</script>