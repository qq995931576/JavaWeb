package com.achang.utils;

import com.achang.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/******
 @author 阿昌
 @create 2020-11-28 15:52
 *******
 */
public class WebUtils {
    /**
     * 把Map中的值注入到对应的Javabean属性中
     * @param value
     * @param bean
     */
    public  static <T>T copyParamToBean(Map value, T bean){
        try {
            System.out.println("注入之前： "+bean);
            /**
             * 把所有的请求参数都注入到user对象中
             */
            //pupulate()，参数1:接收注入的对象；参数2:即将注入的键值对Map
            BeanUtils.populate(bean,value);
            System.out.println("注入之后： "+bean);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }


    /**
     * 将字符串转化为int类型的数据
     * @param str
     * @return
     */
    public static int parseInt(String str,int defaultValue){
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }



}
