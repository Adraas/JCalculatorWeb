package ru.wkn.servlets;

import ru.wkn.RepositoryFacade;
import ru.wkn.calculator.CalculatorExpressionCompiler;
import ru.wkn.calculator.CalculatorFacade;
import ru.wkn.entities.Operation;
import ru.wkn.repository.dao.h2.H2Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String expression = req.getParameter("expression");
        int roundingAccuracy = Integer.parseInt(req.getParameter("rounding_accuracy"));

        CalculatorFacade calculatorFacade = new CalculatorFacade(roundingAccuracy);
        CalculatorExpressionCompiler calculatorExpressionCompiler = calculatorFacade.getCalculatorExpressionCompiler();

        if (expression.equals("C")) {
            calculatorExpressionCompiler.allClear();
        } else {
            String cookie = req.getParameter("cookie");
            String result = "";
            char[] expressionAsCharArray = expression.toCharArray();
            for (char symbol : expressionAsCharArray) {
                result = result.concat(calculatorExpressionCompiler.getCurrentAnswerAsString(symbol));
            }
            req.setAttribute("result", result);
            req.getRequestDispatcher("/calculator/calculator.jsp").forward(req, resp);
            if (cookie == null || !saveOperation(expression.split("=")[0], result, cookie)) {
                resp.sendError(412, "Operation not created!");
            }
        }
    }

    private boolean saveOperation(String content, String result, String cookie) {
        Class<H2Dao> h2DaoClass = H2Dao.class;
        Class<Operation> operationClass = Operation.class;
        RepositoryFacade<Operation, Integer> repositoryFacade = new RepositoryFacade(h2DaoClass, operationClass);

        Operation operation = new Operation(content, result, cookie);
        return repositoryFacade.getService().create(operation);
    }
}
