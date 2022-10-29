<template>
    <el-row justify="center">
        <img alt="shark logo" src="../assets/shark.jpg"/>
        <h1>{{ title }}</h1>
    </el-row>
    <el-row class="f">
        <el-select v-model="tsType" class="m-2" size="large">
            <el-option
                    key="en"
                    label="英语 -> 汉语"
                    value="1"
            />
            <el-option
                    key="zh"
                    label="汉语 -> 英语"
                    value="2"
            />
        </el-select>
        <el-button type="primary" class="btn_translate" @click="translate" size="large">翻译</el-button>
        <el-button @click="clear" size="large">重置</el-button>
    </el-row>
    <el-row class="f">
        <textarea
            v-model="transLeft"
            placeholder="请输入要翻译的内容"
        ></textarea>

        <textarea v-model="transRight"></textarea>
    </el-row>
</template>

<script lang="ts">
    import axios from 'axios'
    import {defineComponent, ref, reactive, onMounted} from 'vue';

    const tsType = ref('')
    const transLeft = ref('')
    const transRight = ref('')

    let toTransate = function (type: string) {
        let inteface_name
        if (type == '1') {
            inteface_name = 'queryMedicineZH'
        } else if (type == '2') {
            inteface_name = 'queryMedicineEN'
        } else {
            ElNotification({
                title: '警告',
                message: '请选择翻译类型',
                type: 'warning',
            })
            return
        }

        let arr:Array<String> = transLeft.value.split("\n");
        console.log(arr)
        axios.get(`/blackshark/${inteface_name}?queryList=${arr}`).then(
            response => {
                console.log(response)
                let result:Array<String> = response.data.data;
                result.forEach((value, index, array)=>{
                    transRight.value += value + "\n";
                });
            },
            error => {
                console.log(error)
            }
        )
    }



    export default defineComponent({
        name: 'blackshark',
        props: {
            title: {
                required: true,
                default: () => [],
                type: String,
            },
        },
        setup(props) {
            const translate = () => {
                transRight.value = '';
                if (!transLeft.value) {
                    ElNotification({
                        title: '错误',
                        message: '请输入需要翻译的内容',
                        type: 'error',
                    })
                    return
                }
                toTransate(tsType.value)
            }

            const clear = () => {
                transLeft.value = '';
                transRight.value = '';
            }

            onMounted(() => {
                tsType.value = '1'
            })

            return {
                transLeft,
                transRight,
                tsType,
                translate,
                clear
            };
        },
    });

</script>

<style scoped>

    textarea {
        font-size: 14px;
        width: 30%;
        height: 300px;
        margin: 0px 30px 0px 0px;
    }

    .btn_translate{
        margin-left: 10px;
    }

    .f {
        left: 20%;
    }

    .el-row {
        margin-bottom: 20px;
    }

    .el-row:last-child {
        margin-bottom: 0;
    }

    .el-col {
        border-radius: 4px;
    }

    .grid-content {
        border-radius: 4px;
        min-height: 36px;
    }

</style>
