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
            <FormItem label="资产名称" prop="assetName">
                <Input v-model="form.assetName" clearable style="width:570px" />
            </FormItem>
            <FormItem label="型号" prop="model">
                <Input v-model="form.model" clearable style="width:570px" />
            </FormItem>
            <FormItem label="单价" prop="unitPrice">
                <InputNumber v-model="form.unitPrice" style="width:570px" :min="0"></InputNumber>
            </FormItem>
            <FormItem label="备注" prop="remarks">
                <Input v-model="form.remarks" clearable style="width:570px" />
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
    editAssetsType
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
                assetName: "",
                model: "",
                unitPrice: "",
                totalPrice: "",
                remarks: "",
                number: "",
                existingNumber: "",
                nature: "固定资产",
            },
            // 表单验证规则
            formValidate: {
                assetName: [{
                    required: true,
                    message: "不能为空",
                    trigger: "blur"
                }],
                model: [{
                    required: true,
                    message: "不能为空",
                    trigger: "blur"
                }],
                unitPrice: [{
                    type: "number",
                    required: true,
                    message: "不能为空",
                    trigger: "blur"
                }],
            }
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
                    editAssetsType(this.form).then(res => {
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
// 引入通用样式 具体路径自行修改
@import "../../../styles/single-common.less";
</style>
