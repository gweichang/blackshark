package cn.cw.blackshark.controller;

import cn.cw.blackshark.bean.ResponseVO;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author gao.weichang
 * @version 1.0.0
 * @ClassName cn.cw.blackshark.controller.TranslateControllerTest
 * @Description 测试模块
 * @createTime 2022年10月27日 下午11:51
 */
class TranslateControllerTest {

    @Test
    void queryMedicineZH() {
        String str = "Anion binding";
//        str = "test";
        TranslateController translateController = new TranslateController();
        ResponseVO vo = translateController.queryMedicineZH(str);
        System.out.println(JSON.toJSONString(vo));
    }

    @Test
    void queryMedicineEN() {
    }
}
