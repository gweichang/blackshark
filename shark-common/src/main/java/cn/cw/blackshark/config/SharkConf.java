package cn.cw.blackshark.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author gao.weichang
 * @version 1.0.0
 * @ClassName cn.cw.blackshark.config.SharkConf
 * @Description TODO
 * @createTime 2022年10月29日 下午11:07
 */

@Component
@Data
public class SharkConf {

    @Value("${app.id}")
    public String APP_ID;

    @Value("${security.key}")
    public String SECURITY_KEY;
}
