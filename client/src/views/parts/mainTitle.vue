<template>
    <div id="root">
        <label>{{(currentSession.alias==''||currentSession.alias==null)?currentSession.name:currentSession.alias}}</label>
    </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
    name:"Title",
    computed:{
        ...mapState(["currentSession"])
    }
}
</script>

<style scoped>
#root{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100%;
}
label{
    width: 95%;
    font-size: 18px;
    font-weight: 500;
}
</style>