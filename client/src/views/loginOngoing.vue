<template>
    <div><label>{{label}}</label></div>
</template>

<script>
export default {
    name:"Ongoing",
    data(){
        return{
            label:'登录中',
            dots:0,
            stop:false
        }
    },
    methods:{
        change(){
            if(this.dots < 5)
            {
                this.label+='.';
                this.dots++;
            }
            else
            {
                this.label='登录中';
                this.dots=0;
            }
        }
    },
    mounted:function(){
        setInterval(this.change,366);
    }
}
</script>

<style scoped>
div{
    display: flex;
    height: 300px;
    flex-direction: column;
    text-align: center;
    justify-content: center;
}
label{
    color: rgb(255, 145, 0);
    font-size: 18px;
    font-weight: bold;
}
</style>