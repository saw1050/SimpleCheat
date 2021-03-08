<template>
    <div id = "send">
        <el-button type="primary" size="mini" @click="send">发送</el-button>
    </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex';
export default {
    name: "Send",
    computed:{
        ...mapState(['inputting']),
    },
    methods:{
        ...mapMutations(["fillInput"]),
        send(){
            if(this.inputting != null && this.inputting != '')
            {
                console.log(this.inputting);
                this.fillInput('');
                this.$parent.clearWriter();
            }
        }
    },
    mounted(){
        let self = this;
        document.onkeydown = function(event) {
            if(event.keyCode == 13 && event.ctrlKey)
            {
                self.send();
                document.getElementById("writerInput").focus();
            }
        }
    },
    beforeUnmount() {
        this.fillInput('');
        document.onkeydown = null;
    }
}
</script>