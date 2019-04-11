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
import java.util.HashMap;
import java.util.Map;

public class CalculatorServlet extends HttpServlet {

    private static Map<String, Operation> cookieOperationMap = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookie = req.getParameter("cookie");
        Operation operation = getOperationByCookie(cookie);

        char symbol = req.getParameter("symbol").toCharArray()[0];
        int roundingAccuracy = Integer.parseInt(req.getParameter("rounding_accuracy"));

        CalculatorFacade calculatorFacade = new CalculatorFacade(roundingAccuracy);
        CalculatorExpressionCompiler calculatorExpressionCompiler = calculatorFacade.getCalculatorExpressionCompiler();

        if (symbol == 'C') {
            calculatorExpressionCompiler.allClear();
            resp.setHeader("result", "0");
        } else {
            String result = calculatorExpressionCompiler.getCurrentAnswerAsString(symbol);
            boolean isSaved = false;
            if (operationReady(operation)) {
                operation.setOperationResult(result);
                isSaved = saveOperation(operation);
            }
            resp.setHeader("result", "0");
            if (isSaved) {
                resp.sendError(412, "Operation not created!");
            }
            req.getRequestDispatcher("/calculator/calculator.jsp").forward(req, resp);
        }
    }

    private boolean saveOperation(Operation operation) {
        cookieOperationMap.remove(operation.getCookie());
        Class<H2Dao> h2DaoClass = H2Dao.class;
        Class<Operation> operationClass = Operation.class;
        RepositoryFacade<Operation, Integer> repositoryFacade = new RepositoryFacade(h2DaoClass, operationClass);
        return repositoryFacade.getService().create(operation);
    }

    private Operation getOperationByCookie(String cookie) {
        if (cookieOperationMap.containsKey(cookie)) {
            return cookieOperationMap.get(cookie);
        } else {
            return new Operation("", null, cookie);
        }
    }

    private boolean operationReady(Operation operation) {
        //
        return true;
    }
}
