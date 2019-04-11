package ru.wkn.servlets;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.User;
import ru.wkn.repository.dao.h2.H2Dao;
import ru.wkn.repository.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("full_name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean isCreated = saveUser(fullName, login, password);
        if (isCreated) {
            req.getRequestDispatcher("/calculator/sign_in.jsp").forward(req, resp);
        } else {
            resp.sendError(412, "User not created!");
        }
    }

    private boolean saveUser(String fullName, String login, String password) {
        Class<H2Dao> h2DaoClass = H2Dao.class;
        Class<User> userClass = User.class;
        RepositoryFacade<User, Integer> repositoryFacade = new RepositoryFacade(h2DaoClass, userClass);
        String cookie = ((UserService) repositoryFacade.getService()).registryCookie(fullName, login, password);

        User user = new User(fullName, login, password, cookie);
        return repositoryFacade.getService().create(user);
    }
}
