<template>
    <div>
        <Card>
            <div slot="title">
                <div class="edit-head">
                    <a @click="close" class="back-title">
                        <Icon type="ios-arrow-back" />返回
                    </a>
                    <div class="head-name">编辑</div>
                    <span></span>
                    <a @click="close" class="window-close">
                        <Icon type="ios-close" size="31" class="ivu-icon-ios-close" />
                    </a>
                </div>
            </div>
            <Form ref="form" :model="form" :label-width="100" :rules="formValidate" label-position="left">
                <FormItem label="姓名" prop="name">
                    <Input v-model="form.name" clearable style="width:570px" />
                </FormItem>
                <FormItem label="性别" prop="sex">
                    <Select v-model="form.sex" clearable style="width:570px">
                        <Option value="0">请自行编辑下拉菜单</Option>
                    </Select>
                </FormItem>
                <FormItem label="出生地" prop="birthplace">
                    <Input v-model="form.birthplace" clearable style="width:570px" />
                </FormItem>
                <FormItem label="年龄" prop="age">
                    <InputNumber v-model="form.age" min="0" max="5000000" style="width:570px"></InputNumber>
                </FormItem>
                <FormItem label="电话号码" prop="mobile">
                    <Input v-model="form.mobile" clearable style="width:570px" />
                </FormItem>
                <FormItem label="身份证" prop="idCard">
                    <Input v-model="form.idCard" clearable style="width:570px" />
                </FormItem>
                <FormItem label="家庭地址" prop="address">
                    <Input v-model="form.address" clearable style="width:570px" />
                </FormItem>
                <FormItem label="状态" prop="status">
                    <Select v-model="form.status" clearable style="width:570px">
                        <Option value="0">请自行编辑下拉菜单</Option>
                    </Select>
                </FormItem>
                <FormItem label="社保卡状态" prop="cardStatus">
                    <Select v-model="form.cardStatus" clearable style="width:570px">
                        <Option value="0">请自行编辑下拉菜单</Option>
                    </Select>
                </FormItem>
                <FormItem label="社保卡号" prop="cardNumber">
                    <Input v-model="form.cardNumber" clearable style="width:570px" />
                </FormItem>
                <FormItem label="余额" prop="money">
                    <InputNumber v-model="form.money" min="0" max="5000000" style="width:570px"></InputNumber>
                </FormItem>
                <FormItem label="参加的保险" prop="insuranceType">
                    <Select v-model="form.insuranceType" clearable style="width:570px">
                        <Option value="0">请自行编辑下拉菜单</Option>
                    </Select>
                </FormItem>
                <FormItem label="保险名称" prop="insuranceName">
                    <Input v-model="form.insuranceName" clearable style="width:570px" />
                </FormItem>
                <Form-item class="br">
                    <Button @click="handleSubmit" :loading="submitLoading" type="primary">提交并保存</Button>
                    <Button @click="handleReset">重置</Button>
                    <Button type="dashed" @click="close">关闭</Button>
                </Form-item>
            </Form>
        </Card>
    </div>
</template>

<script>
import {
    editRoster
} from "@/api/index";
export default {
    name: "edit",
    components: {},
    props: {
        data: Object
    },
    data() {
        return {
            submitLoading: false, // 表单提交状态
            form: { // 添加或编辑表单对象初始化数据
                name: "",
                sex: "",
                birthplace: "",
                age: 0,
                mobile: "",
                idCard: "",
                address: "",
                status: "",
                cardStatus: "",
                cardNumber: "",
                money: 0,
                insuranceType: "",
                insuranceName: "",
            },
            // 表单验证规则
            formValidate: {}
        };
    },
    methods: {
        init() {
            this.handleReset();
            this.form = this.data;
        },
        handleReset() {
            this.$refs.form.resetFields();
        },
        handleSubmit() {
            this.$refs.form.validate(valid => {
                if (valid) {
                    editRoster(this.form).then(res => {
                        this.submitLoading = false;
                        if (res.success) {
                            this.$Message.success("操作成功");
                            this.submited();
                        }
                    });
                }
            });
        },
        close() {
            this.$emit("close", true);
        },
        submited() {
            this.$emit("submited", true);
        }
    },
    mounted() {
        this.init();
    }
};
</script>

<style lang="less">
// 建议引入通用样式 具体路径自行修改 可删除下面样式代码
@import "../../../styles/single-common.less";
</style>
