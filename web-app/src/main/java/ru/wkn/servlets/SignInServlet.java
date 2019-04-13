package ru.wkn.servlets;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.User;
import ru.wkn.repository.dao.h2.H2Dao;
import ru.wkn.repository.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = getUser(login, password);
        resp.setContentType("text/html");
        if (user != null) {
            resp.addCookie(new Cookie("user", user.getCookie()));
            req.getRequestDispatcher("/calculator/profile.jsp").forward(req, resp);
        } else {
            resp.setHeader("result", "User not found!");
            req.getRequestDispatcher("/calculator/sign_in.jsp").forward(req, resp);
        }
    }

    private User getUser(String login, String password) {
        Class<H2Dao> h2DaoClass = H2Dao.class;
        Class<User> userClass = User.class;
        RepositoryFacade<User, Integer> repositoryFacade = new RepositoryFacade(h2DaoClass, userClass);
        return ((UserService) repositoryFacade.getService()).logIn(login, password);
    }
}
