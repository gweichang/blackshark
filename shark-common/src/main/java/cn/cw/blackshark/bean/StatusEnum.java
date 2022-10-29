package cn.cw.blackshark.bean;

/**
 * @author gao.weichang
 * @version 1.0.0
 * @ClassName com.yoyosys.license.server.bean.ExceptionEnum
 * @Description 状态编码
 * @createTime 2021年11月22日 下午5:00
 */
public enum StatusEnum {

    SUCCESS(200, "请求成功"),
    ERROR_PARAMETER(300, "接口参数错误"),
    ERROR_BAIDU_INTERFACE(301, "百度垂直翻译接口错误");

    private int value;

    private String msg;

    public int getValue() {
        return value;
    }

    public String getMsg() {
        return msg;
    }

    StatusEnum(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

}
