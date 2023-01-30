<template>
    <v-btn
        :color="color"
        class="ma-2 white--text"
        @click="onClick"
        >
            {{label}}
        <v-icon right dark>
            {{ icon }}
        </v-icon>
    </v-btn>
</template>

<script>
export default {
    name : 'ButtonVue',
    props : {
        propColor : String,
        propLabel : String,
        propIcon : String
    },
    methods : {
        onClick() {
            this.$emit('submit')
        }
    },
    computed:{
        color () {return this.$props.propColor},
        label() {return this.$props.propLabel},
        icon() {return this.$props.propIcon}
    }
}
</script>

<!-- 버튼 컴포넌트 -->
<!-- 
    1. color
    2. label
    3. icon
 -->