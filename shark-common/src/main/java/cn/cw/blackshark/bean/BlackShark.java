package cn.cw.blackshark.bean;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gao.weichang
 * @version 1.0.0
 * @ClassName com.nlf.calendar.translate.bean.BlackShark
 * @Description 小鲨鱼词库
 * @createTime 2022年10月20日 下午4:47
 */
public class BlackShark {

    public static Map<String, String> sharks_zh = new HashMap();
    public static Map<String, String> sharks_en = new HashMap();

    public void initBlackShark() {
        readFileByLines("shark.dic");
    }

    public static void readFileByLines(String fileName) {
        BufferedReader reader = null;
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                if(tempString.contains("=")){
                    String[] temp = tempString.split("=");
                    sharks_en.put(temp[0].trim().toLowerCase(),temp[1].trim());
                    sharks_zh.put(temp[1].trim(),temp[0].trim());
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void main(String[] args) {
        BlackShark blackShark = new BlackShark();
        blackShark.initBlackShark();
        System.out.println(sharks_en.get("response to organic substance"));
        System.out.println(sharks_en.get("Patched binding".toLowerCase()));
        System.out.println(sharks_zh.get("信号"));
    }
}
