package com.achang.utils;

import javax.servlet.http.Cookie;

/******
 @author 阿昌
 @create 2020-11-30 21:30
 *******
 */
public class CookieUtils {

    /**
     * 查找指定名称的cookie对象
     *
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies.length == 0 || cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
