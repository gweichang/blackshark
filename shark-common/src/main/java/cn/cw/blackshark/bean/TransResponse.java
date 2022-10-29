package cn.cw.blackshark.bean;

import lombok.Data;

import java.util.List;

/**
 * @author gao.weichang
 * @version 1.0.0
 * @ClassName com.nlf.calendar.translate.bean.TransResponse
 * @Description TODO
 * @createTime 2022年10月18日 下午1:50
 */
@Data
public class TransResponse {

    private String from;
    private String to;
    private List<TransResult> trans_result;
}
