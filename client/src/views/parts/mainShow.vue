<template>
    <div>
        <div v-for="i in messages" :key="i">
            <OtherMessage v-if="i.src == currentSession.username" :msg="i"></OtherMessage>
            <SelfMessage v-else-if="i.dst == currentSession.username" :msg="i"></SelfMessage>
        </div>
    </div>
</template>

<script>
import OtherMessage from './othermsg';
import SelfMessage from './selfmsg';
import { mapState } from 'vuex';
export default {
    name:"Show",
    components:{ OtherMessage, SelfMessage },
    computed:{
        ...mapState(["currentSession", "messages"]),
    }
}
</script>