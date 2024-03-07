package org.example.web7;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

public class Auth {
    public static String cookieName = "CALC";
    private static final Cookie[] empty = new Cookie[]{};
    private static Cookie[] ensureNotNull(Cookie[] cs){
        return cs == null ? empty : cs;
    }
    public static Optional<String> getCookieValue(HttpServletRequest req){
        return Arrays.stream(ensureNotNull(req.getCookies()))
                .filter(c -> c.getName().equals(cookieName))
                .findFirst()
                .map(Cookie::getValue);

    }

    public static void setCookieValue(String cookieValue, HttpServletResponse rs){
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(10*60); //seconds
        rs.addCookie(cookie);
    }

    public static void clearCookie(HttpServletResponse rs){
        Cookie cookie = new Cookie(cookieName, "");
        cookie.setMaxAge(0); //seconds
        rs.addCookie(cookie);
    }

    public static void renderUnregistered(HttpServletResponse resp){
        resp.setStatus(401);
    }
}
