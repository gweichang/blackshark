package cn.cw.blackshark.bean;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gao.weichang
 * @version 1.0.0
 * @ClassName com.yoyosys.license.server.bean.ResponseVO
 * @Description 用于返回请求结果
 * @createTime 2021年11月22日 下午5:57
 */
@Data
public class ResponseVO<T> implements Serializable {

    // 错误码
    private Integer code;

    // 数据
    private T data;

    // 消息
    private String message;

    // 时间戳
    private String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    public ResponseVO() {
    }

    private ResponseVO(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    private ResponseVO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /*
    认证成功，成功可以不传入CODE
     */
    public static <T> ResponseVO success(T data) {
        return new ResponseVO<>(StatusEnum.SUCCESS.getValue(), data, "");
    }

    public static <T> ResponseVO<T> success(T data, String message) {
        return new ResponseVO<>(StatusEnum.SUCCESS.getValue(), data, message);
    }

    public static <T> ResponseVO<T> success(String message) {
        return new ResponseVO<>(StatusEnum.SUCCESS.getValue(), null, message);
    }

    /*
    认证失败，失败类型较多，必须传入CODE
     */
    public static <T> ResponseVO<T> fail(StatusEnum code) {
        return new ResponseVO<>(code.getValue(), code.getMsg());
    }

    public static <T> ResponseVO<T> fail(StatusEnum code, String message) {
        return new ResponseVO<>(code.getValue(), message);
    }


}
