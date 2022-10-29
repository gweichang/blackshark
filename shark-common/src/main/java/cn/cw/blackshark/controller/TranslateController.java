package cn.cw.blackshark.controller;

import cn.cw.blackshark.bean.*;
import cn.cw.blackshark.config.SharkConf;
import cn.cw.blackshark.translate.TransApi;
import cn.cw.blackshark.utils.SharkUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gao.weichang
 * @version 1.0.0
 * @ClassName com.nlf.calendar.controller.TranslateController
 * @Description 垂直翻译
 * @createTime 2022年10月20日 下午1:57
 */

@RestController
@RequestMapping(value = "/blackshark")
public class TranslateController {

    @Autowired
    SharkConf sharkConf;

    @RequestMapping(value = "/queryMedicineZH", method = RequestMethod.GET)
    public ResponseVO queryMedicineZH(String[] queryList) {

        if (queryList == null || "".equals(queryList)) {
            return ResponseVO.fail(StatusEnum.ERROR_PARAMETER);
        }
        List<String> list = SharkUtils.doQuery(queryList, "auto", "zh", "medicine", sharkConf.getAPP_ID(), sharkConf.getSECURITY_KEY());
        return ResponseVO.success(list, "");
    }

    @RequestMapping(value = "/queryMedicineEN", method = RequestMethod.GET)
    public ResponseVO queryMedicineEN(String[] queryList) {
        if (queryList == null || "".equals(queryList)) {
            return ResponseVO.fail(StatusEnum.ERROR_PARAMETER);
        }
        List<String> list = SharkUtils.doQuery(queryList, "auto", "en", "medicine", sharkConf.getAPP_ID(), sharkConf.getSECURITY_KEY());
        return ResponseVO.success(list, "");
    }
}
