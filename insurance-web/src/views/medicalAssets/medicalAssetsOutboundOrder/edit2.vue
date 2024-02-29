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
                    <Input v-model="form.assetName" disabled style="width:570px" />
                </FormItem>
                <FormItem label="领用人" prop="recipients">
                    <Input v-model="form.recipients" disabled style="width:570px" />
                </FormItem>
                <FormItem label="型号" prop="model">
                    <Input v-model="form.model" disabled style="width:570px" />
                </FormItem>
                <FormItem label="单价" prop="unitPrice">
                    <InputNumber v-model="form.unitPrice" disabled style="width:570px"></InputNumber>
                </FormItem>
                <FormItem label="数量" prop="number">
                    <InputNumber v-model="form.number" style="width:570px" @on-change="changeNumber" :min="0"
                        :max="maxNumber"></InputNumber>
                </FormItem>
                <FormItem label="总价">
                    <Input v-model="form.totalPrice" style="width:570px" readonly />
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
    editWarehouseOut
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
                recipients: "",
                model: "",
                unitPrice: 0,
                number: "0.0",
                remarks: "",
                nature: '耗材',
                recipientsId: '',
                totalPrice: '',
            },
            // 表单验证规则
            formValidate: {
                number: [{
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
            this.maxNumber = parseFloat(this.form.existNumber);
            if (this.form.unitPrice != undefined && this.form.unitPrice != null) {
                this.form.totalPrice = parseFloat(this.form.unitPrice) * parseFloat(this.form.number);
            }
        },
        changeNumber(e) {
            if (this.form.unitPrice != undefined && this.form.unitPrice != null) {
                this.form.totalPrice = parseFloat(this.form.unitPrice) * parseFloat(this.form.number);
            }
        },
        handleReset() {
            this.$refs.form.resetFields();
        },
        handleSubmit() {
            this.$refs.form.validate(valid => {
                if (valid) {
                    editWarehouseOut(this.form).then(res => {
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
