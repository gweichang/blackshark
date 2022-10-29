package cn.cw.blackshark;

import cn.cw.blackshark.bean.BlackShark;
import cn.cw.blackshark.utils.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author gao.weichang
 * @version 1.0.0
 * @ClassName cn.cw.blackshark.BlackSharkApplication
 * @Description TODO
 * @createTime 2022年10月20日 下午8:58
 */

@SpringBootApplication(scanBasePackages = {"cn.cw"})
@ServletComponentScan
@EnableScheduling
public class BlackSharkApplication {

    public static void main(String[] args) {
        // 1.设置spring上下文
        ApplicationContext context = SpringApplication.run(BlackSharkApplication.class, args);
        SpringContextUtil.setApplicationContext(context);
        //2.启动
        BlackSharkApplication blackSharkApplication = SpringContextUtil.getBean(BlackSharkApplication.class);
        BlackShark blackShark = new BlackShark();
        blackShark.initBlackShark();
    }
}
