/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Optional;
import java.util.stream.Stream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */

public class Utils {
    public static String getCookieValue(String name, HttpServletRequest request){
        if (request.getCookies()!=null) {
            Optional<Cookie> mc= Stream.of(request.getCookies()).filter(c->c.getName().equals("M")).findFirst();
            return mc.isPresent()? mc.get().getValue():null;
        }
    return null;
    }
}
