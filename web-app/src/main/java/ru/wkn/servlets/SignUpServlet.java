package ru.wkn.servlets;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.EntityType;
import ru.wkn.entities.User;
import ru.wkn.repository.dao.DaoType;
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

        if (checkStringToValid(fullName, ',', ';', ':')
                && checkStringToValid(login, ' ', ',', ';', ':')
                && checkStringToValid(password, ' ', ',', ';', ':')) {
            boolean isCreated = saveUser(fullName, login, password);
            if (isCreated) {
                req.getRequestDispatcher("/calculator/sign_in.jsp").forward(req, resp);
            } else {
                resp.setHeader("Result", "user_not_created");
                req.getRequestDispatcher("/calculator/sign_up.jsp").forward(req, resp);
            }
        } else {
            resp.setHeader("Result", "parameters_with_forbidden_symbols");
            req.getRequestDispatcher("/calculator/sign_up.jsp").forward(req, resp);
        }
    }

    private boolean checkStringToValid(String value, char... forbiddenSymbols) {
        for (char forbiddenSymbol : forbiddenSymbols) {
            if (value.contains(String.valueOf(forbiddenSymbol))) {
                return false;
            }
        }
        return true;
    }

    private boolean saveUser(String fullName, String login, String password) {
        RepositoryFacade repositoryFacade = new RepositoryFacade(DaoType.H2DAO, EntityType.USER);
        String cookie = ((UserService) repositoryFacade.getService()).registryCookie(fullName, login, password);

        User user = new User(fullName, login, password, cookie);
        return repositoryFacade.getService().create(user);
    }
}
