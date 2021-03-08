<template>
    <div id="root">
        <div id="msg">
            <div id="bg">
                <p>{{msg.message}}</p>
            </div>
        </div>
        <div id="snap">
            <img src="../../assets/20201228122504.jpg" width="40" height="40">
        </div>
    </div>
</template>

<script>
export default {
    name:"SelfMessage",
    props:["msg"]
}
</script>

<style scoped>
#root{
    width: 75%;
    display: flex;
    float: right;
    border-top-style: solid;
    border-bottom-style: solid;
    border-width: 8px;
    border-color: whitesmoke;
}
#snap{
    display: flex;
    justify-content: center;
    width: 20%;
    border-top-style: solid;
    border-width: 5px;
    border-color: whitesmoke;
}
#msg{
    width: 80%;
}
#bg{
    display: flex;
    justify-content: flex-end;
    width: 100%;
}
p{
    max-width: 95%;
    font-family: "华文黑体";
    font-size: 13px;
    font-weight: 500;
    letter-spacing: 1px;
    word-break: normal;
    white-space: pre-line;
    word-wrap: break-word;
    border-style: solid;
    border-width: 7px;
    border-radius: 9px;
    border-color: rgb(78, 160, 255);
    background-color:rgb(78, 160, 255);
    color: azure;
    margin-top: 0;
}
</style>