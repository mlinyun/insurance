<template>
    <div :style="{ height: clientHeight }" class="topDiv">
        <Row :gutter="20">
            <!-- 主体部分 -->
            <div class="body">
                <!--logo标题图片 -->
                <img class="title" src="../../assets/logo2.png" alt="" />
                <!--第二排内容 -->
                <div class="awayMenu">
                    <!--左侧 -->
                    <div class="awayLeft">
                        <span class="manage2">
                            欢迎
                            <!--用户名称 -->
                            <span>{{ name }}</span>
                        </span>
                        <!--登入地址 -->
                        <div class="manage">登入地址：{{ location }}</div>
                    </div>
                    <!--时间，上下布局 -->
                    <div class="bottom">
                        <!--年月日 -->
                        <span class="showtime">{{ showtime }}</span>
                        <!--时分 -->
                        <span class="showtime2">{{ showtime2 }}</span>
                    </div>
                </div>
                <!--三层标题 -->
                <div class="bigTips">
                    <span style="color:rgba(255,255,255,0.8)">常用模块</span>
                    <span style="67.5%"> </span>
                </div>
                <!--常用按钮层 -->
                <div class="buttonMenu">
                    <!--常用按钮盒子 -->
                    <div class="addMenuBox">
                        <!--循环遍历按钮 -->
                        <div class="addMenu" v-for="(item, index) in addMenuTempList" :key="index"
                            @click="selectItem(item)">
                            {{ item.title }}
                        </div>
                    </div>
                    <!--分隔线 -->
                    <div class="shu"></div>
                    <!--右侧3按钮 -->
                    <div class="threeButton">
                        <!--按钮1 -->
                        <div class="button" @click="toDaiBanPage">
                            <div class="left">
                                <!--图片1 -->
                                <img class="homeThreeIcon" src="../../assets/homeIcon1.png" alt=""/>
                                <!--内容1 -->
                                <span class="text">我的待办</span>
                            </div>
                        </div>
                        <!--按钮2 -->
                        <div class="button" @click="toFaQiPage">
                            <div class="left">
                                <!--图片2 -->
                                <img class="homeThreeIcon" src="../../assets/homeIcon2.png" alt=""/>
                                <!--内容2 -->
                                <span class="text">我的未办</span>
                            </div>
                        </div>
                        <!--按钮3 -->
                        <div class="button" @click="toJingBanPage">
                            <div class="left">
                                <!--图片3 -->
                                <img class="homeThreeIcon" src="../../assets/homeIcon3.png" alt=""/>
                                <!--内容3 -->
                                <span class="text">我的经办</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </Row>
    </div>
</template>
    
<script>
import Cookies from "js-cookie";
import {
    ipInfo,
    getMyDoorList6
} from "@/api/index";
export default {
    name: "home",
    data() {
        return {
            name: "",
            showtime: "",
            showtime2: "",
            location: "公司内网",
            addMenuTempList: [],
            number1: 0,
            number2: 0,
            number3: 0,
            number1List: [],
            number2List: [],
            number3List: []
        };
    },

    methods: {
        init() {
            this.getMyDoorListFx();
            let user = JSON.parse(Cookies.get("userInfo"));
            this.name = user.nickname;
            this.getNowTime();
            ipInfo().then((res) => {
                if (res.success) {
                    this.location = res.result;
                }
            });
            this.timer = setInterval(this.getNowTime, 1000);
        },
        selectItem(e) {
            if (e.name != undefined && e.name != "null") {
                this.$router.push({
                    name: e.name,
                });
            }
        },
        toDaiBanPage() {
            this.$Message.success("正在开发，敬请期待！");
        },
        toFaQiPage() {
            this.$Message.success("正在开发，敬请期待！");
        },
        toJingBanPage() {
            this.$Message.success("正在开发，敬请期待！");
        },
        toOwnMenu() {
            this.$router.push("/myHome");
        },
        getMyDoorListFx() {
            var that = this;
            getMyDoorList6().then((res) => {
                that.addMenuTempList = res.result;
            });
        },
        getNowTime() {
            this.showtime = this.format(new Date(), "yyyy年MM月dd日");
            this.showtime2 = this.format(new Date(), "HH:mm:dd");
        },
    },
    mounted() {
        this.init();
        this.clientHeight = `${document.documentElement.clientHeight}`;
        let that = this;
        window.onresize = function () {
            this.clientHeight = `${document.documentElement.clientHeight}`;
            if (that.$refs.page) {
                that.$refs.page.style.minHeight = clientHeight - 100 + "px";
            }
        };
    },
    watch: {
        clientHeight() {
            this.changeFixed(this.clientHeight);
        },
    },
};
</script>
    
<style lang="less" scoped>
@import "../../styles/home.less";
</style>
    