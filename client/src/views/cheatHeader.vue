<template>
    <div class="top">
        <div class="middle">
            <label>Cheater</label>
        </div>
    </div>
</template>

<script>
export default {
    name:"CheatHeader"
}
</script>

<style scoped>
.top{
    display: flex;
    width: 100%;
    height: 100%;
    background-color:rgba(24, 24, 24, 0.774);
    flex-direction: column;
    justify-content: center;
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
}
.middle{
    width: 50%;
    height: 36px;
    text-align: center;
    margin: auto auto auto auto;
}
label{
    color: white;
    font-size: 20px;
    font-weight: bold;
}
</style>