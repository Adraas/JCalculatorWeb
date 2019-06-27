package ru.wkn.util;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.EntityType;
import ru.wkn.repository.dao.DaoType;
import ru.wkn.repository.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieManager {

    private static String cookieName = "calculator-user";

    public static String getCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        int i = 0;
        if (cookies != null) {
            if (cookies.length > 0) {
                while (i < cookies.length - 1 && !cookies[i].getName().equals(cookieName)) {
                    i++;
                }
                Cookie cookie = cookies[i];
                if (cookie.getName().equals(cookieName)) {
                    String cookieValue = cookie.getValue();
                    RepositoryFacade repositoryFacade = new RepositoryFacade(DaoType.H2DAO, EntityType.USER);
                    if (((UserService) repositoryFacade.getService()).checkCookieToExist(cookieValue)) {
                        return cookie.getValue();
                    }
                }
            }
        }
        return null;
    }

    public static String getCookieName() {
        return cookieName;
    }

    public static void setCookieName(String cookieName) {
        CookieManager.cookieName = cookieName;
    }
}
