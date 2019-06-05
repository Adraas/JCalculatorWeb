package ru.wkn.servlets;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.EntityType;
import ru.wkn.entities.User;
import ru.wkn.repository.dao.DaoType;
import ru.wkn.repository.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Enumeration;

public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> authorizationHeaderData = req.getHeaders("Authorization");
        String login = null;
        String password = null;
        if (authorizationHeaderData.hasMoreElements()) {
            login = new String(Base64.getDecoder().decode(authorizationHeaderData.nextElement()));
        }
        if (authorizationHeaderData.hasMoreElements()) {
            password = new String(Base64.getDecoder().decode(authorizationHeaderData.nextElement()));
        }

        if (!authorizationHeaderData.hasMoreElements() && login != null && password != null) {
            User user = getUser(login, password);
            resp.setContentType("text/html");
            if (user != null) {
                resp.addCookie(new Cookie("user", user.getCookie()));
                req.getRequestDispatcher("/calculator/profile.jsp").forward(req, resp);
            } else {
                resp.setHeader("Result", "user_not_found");
                req.getRequestDispatcher("/calculator/sign_in.jsp").forward(req, resp);
            }
        } else {
            resp.setHeader("Result", "wrong_parameters_number");
            req.getRequestDispatcher("/calculator/sign_in.jsp").forward(req, resp);
        }
    }

    private User getUser(String login, String password) {
        RepositoryFacade repositoryFacade = new RepositoryFacade(DaoType.H2DAO, EntityType.USER);
        return ((UserService) repositoryFacade.getService()).logIn(login, password);
    }
}
