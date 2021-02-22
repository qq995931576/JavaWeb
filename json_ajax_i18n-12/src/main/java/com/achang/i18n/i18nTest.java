package com.achang.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/******
 @author 阿昌
 @create 2020-12-04 11:45
 *******
 */
public class i18nTest {

    @Test
    public void testLocale() {
        //getDefault()：获取你系统默认的语言、国家信息
        Locale locale = Locale.getDefault();

        System.out.println(locale);// zh_CN

        //getAvailableLocales()：获取支持的语音、国家信息
        //遍历
        for (Locale availableLocale : Locale.getAvailableLocales()) {
            System.out.println(availableLocale);
        }

        //获取中文，中文的常量的Locale对象
        System.out.println(Locale.CANADA);// zh_CN
        //获取英文，美国的常量的Locale对象
        System.out.println(Locale.US);// en_US

    }


    @Test
    public void testI18n() {
        //得到需要的local对象
        Locale locale = Locale.CHINA;
        //通过指定的baseName和Locale对象，来读取相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);

        System.out.println(bundle.getString("username"));
        System.out.println(bundle.getString("password"));
        System.out.println(bundle.getString("sex"));
        System.out.println(bundle.getString("age"));


    }


}
