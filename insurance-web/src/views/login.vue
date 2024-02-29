<template>
    <div class="login">
        <Row justify="center" align="middle" @keydown.enter.native="submitLogin" style="height:100%">
            <div class="loginUp">
                <div class="loginLeft">
                    <img src="../assets/login/logo.png" alt="logo" srcset="">
                    <span class="line"></span>
                    <span class="title">健康护航保盾管理系统</span>
                </div>
            </div>
            <div class="loginMiddle">
                <div class="login-background">
                    <div class="loginBg"></div>
                    <div class="loginRight">
                        <Row class="loginRow">
                            <Tabs v-model="tabName" @on-click="changeTabName" class="loginTab">
                                <TabPane label="账号密码登陆" name="userAndPassword">
                                    <Form ref="usernameLoginForm" :model="form" :rules="usernameLoginFormRules"
                                        class="form">
                                        <FormItem prop="username" class="loginInput">
                                            <Row>
                                                <Input v-model="form.username" size="large" clearable placeholder="登陆账号" autocomplete="off">
                                                    <Icon class="iconfont icon-yonghu" slot="prefix" style="line-height:50px" />
                                                </Input>
                                            </Row>
                                        </FormItem>
                                        <FormItem prop="password">
                                            <Input style="height:50px;line-height:50px" type="password" v-model="form.password" size="large" placeholder="请输入登陆密码" password autocomplete="off">
                                                <Icon class="iconfont icon-mima1" slot="prefix" style="line-height:50px" />
                                            </Input>
                                        </FormItem>
                                        <FormItem prop="imgCode">
                                            <Row type="flex" justify="space-between"
                                                style="align-items: center;overflow: hidden;">
                                                <Input v-model="form.imgCode" size="large" clearable placeholder="请输入验证码" :maxlength="10" class="input-verify" />
                                                <div class="code-image" style="position:relative;font-size:12px;">
                                                    <Spin v-if="loadingCaptcha" fix></Spin>
                                                    <img :src="captchaImg" @click="getCaptchaImg" alt="验证码加载失败" style="width:110px;cursor:pointer;display:block" />
                                                </div>
                                            </Row>
                                        </FormItem>
                                    </Form>
                                    <Row type="flex" justify="space-between" align="middle">
                                        <Checkbox v-model="saveLogin" size="large">是否自动登陆</Checkbox>
                                        <router-link to="/regist">
                                            <a class="forget-pass">没有账号？点我注册</a>
                                        </router-link>
                                    </Row>
                                    <Row>
                                        <Button class="login-btn" type="primary" size="large" :loading="loading" @click="submitLogin" long>
                                            <span v-if="!loading" style="letter-spacing:20px; font-weight:bold">登陆</span>
                                            <span v-else>正在登陆...请稍后</span>
                                        </Button>
                                    </Row>
                                </TabPane>
                                <TabPane label="企业微信扫码" name="mobile">
                                    <div id="qywxsmqywxsm"></div>
                                </TabPane>
                            </Tabs>

                        </Row>
                        <p class="loginBottom">
                            ART YOUR DREAM
                        </p>
                    </div>
                </div>
            </div>
            <div class="loginDown">
                <p style="margin-top:10px">帮助 | 隐私 | 条款</p>
                <p>
                    <span>Copyright © 2023 - 至今 XXX 版权所有</span>
                    <span style="display:inline-block; width:4px;height:6px"></span>
                    <a target="_blank" href="https://beian.miit.gov.cn" style="color:#848585">ICP备案 粤ICP备XXXXXXXX号</a>
                    <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=XXXXXXXXXXXXXX号">
                        <img src="../assets/login/gonganlogo.png" style="margin-left:0 4px 0 6px" alt="" />
                        <p style="display:inline-block;color:#848585">粤公网安备 XXXXXXXXXXXXXX号</p>
                    </a>
                </p>
            </div>
        </Row>
    </div>
</template>

<script>
import {
    login,
    userInfo,
    initCaptcha,
    drawCodeImage
} from "@/api/index";
import Cookies from "js-cookie";
import util from "@/libs/util.js";
export default {
    components: {
    },
    data() {
        return {
            saoMaFx: false,
            captchaId: "",
            captchaImg: "",
            loadingCaptcha: false,
            error: false,
            tabName: "userAndPassword",
            saveLogin: true,
            loading: false,
            form: {
                username: "admin",
                password: "123456",
                mobile: "",
                code: ""
            },
            usernameLoginFormRules: {
                username: [{
                    required: true,
                    message: "账号不能为空",
                    trigger: "blur"
                }],
                password: [{
                    required: true,
                    message: "密码不能为空",
                    trigger: "blur"
                }],
                imgCode: [{
                    required: true,
                    message: "验证码不能为空",
                    trigger: "blur"
                }]
            }
        };
    },
    methods: {
        // 获取图片验证码
        getCaptchaImg() {
            this.loadingCaptcha = true;
            initCaptcha().then(res => {
                this.loadingCaptcha = false;
                if (res.success) {
                    this.captchaId = res.result;
                    this.captchaImg = drawCodeImage + this.captchaId;
                }
            });
        },
        // 切换企业微信登录
        changeTabName(e) {
            if (e != "userAndPassword") {
                window.WwLogin({
                    "id": "qywxsmqywxsm",
                    "appid": "wwf94bb44e76e308f8",
                    "agentid": "1000002",
                    "redirect_uri": "https://artskyhome.com:8080/%23/login",
                    "state": "ZWZ1314520",
                    "href": "",
                });
            }
        },
        // 登录之后处理函数
        afterLogin(res) {
            let accessToken = res.result;
            this.setStore("accessToken", accessToken);
            userInfo().then((res) => {
                if (res.success) {
                    delete res.result.permissions;
                    let roles = [];
                    res.result.roles.forEach((e) => {
                        roles.push(e.name);
                    });
                    delete res.result.roles;
                    this.setStore("roles", roles);
                    this.setStore("saveLogin", this.saveLogin);
                    if (this.saveLogin) {
                        Cookies.set("userInfo", JSON.stringify(res.result), {
                            expires: 7,
                        });
                    } else {
                        Cookies.set("userInfo", JSON.stringify(res.result));
                    }
                    this.setStore("userInfo", res.result);
                    this.$store.commit("setAvatarPath", res.result.avatar);
                    util.initRouter(this);
                    this.$router.push({
                        name: "home_index",
                    });
                } else {
                    this.loading = false;
                }
            });
        },
        // 提交登录
        submitLogin() {
            this.$refs.usernameLoginForm.validate(valid => {
                if (valid) {
                    this.loading = true;
                    login({
                        username: this.form.username,
                        password: this.form.password,
                        code: this.form.imgCode,
                        captchaId: this.captchaId,
                        saveLogin: this.saveLogin
                    }).then(res => {
                        if (res.success) {
                            this.afterLogin(res);
                        } else {
                            this.loading = false;
                            this.getCaptchaImg();
                        }
                    });
                }
            });
        }
    },
    mounted() {
        this.getCaptchaImg();
    }
};
</script>

<style lang="less">
@import "../styles/login.less";
</style>
