package cn.cw.blackshark.utils;

import cn.cw.blackshark.bean.BlackShark;
import cn.cw.blackshark.bean.TransResponse;
import cn.cw.blackshark.bean.TransResult;
import cn.cw.blackshark.config.SharkConf;
import cn.cw.blackshark.translate.TransApi;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gao.weichang
 * @version 1.0.0
 * @ClassName cn.cw.blackshark.utils.SharkUtils
 * @Description 翻译工具类
 * @createTime 2022年10月20日 下午8:58
 */
public class SharkUtils {

    public static List<String> doQuery(String[] queryList, String from, String to, String domain, String app_id, String sercurity_key) {
        List<String> list = new ArrayList<>();
        for (String query : queryList) {

            if (query == null || "".equals(query)) {
                continue;
            }

            String dst = "";

            if ("zh".equals(to)) {
                dst = BlackShark.sharks_en.get(query.trim().toLowerCase());
            } else {
                dst = BlackShark.sharks_zh.get(query.trim().toLowerCase());
            }

            if (dst != null && dst.length() > 0) {
                list.add(dst);
                continue;
            }

            TransApi api = new TransApi(app_id, sercurity_key);
            String result = api.getTransResult(query, from, to, domain);
            TransResponse tr = JSON.parseObject(result, TransResponse.class);
            if (tr == null || tr.getTrans_result() == null) {
                list.add(result);
                continue;
            }
            for (TransResult _result : tr.getTrans_result()) {
                list.add(_result.getDst());
            }
        }
        System.out.println(JSON.toJSONString(list, true));
        return list;
    }
}
