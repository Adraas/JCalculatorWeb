package ru.wkn.servlets;

import ru.wkn.RepositoryFacade;
import ru.wkn.calculator.CalculatorExpressionCompiler;
import ru.wkn.calculator.CalculatorFacade;
import ru.wkn.entities.EntityType;
import ru.wkn.entities.Operation;
import ru.wkn.repository.dao.DaoType;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CalculatorServlet extends HttpServlet {

    private static Map<String, Operation> cookieOperationMap = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        int i = 0;
        while (!cookies[i].getName().equals("user")) {
            i++;
        }
        String cookie = cookies[i].getValue();
        Operation operation = getOperationByCookie(cookie);

        char symbol = req.getParameter("symbol").toCharArray()[0];
        int roundingAccuracy = Integer.parseInt(req.getParameter("rounding_accuracy"));

        CalculatorFacade calculatorFacade = new CalculatorFacade(roundingAccuracy);
        CalculatorExpressionCompiler calculatorExpressionCompiler = calculatorFacade.getCalculatorExpressionCompiler();

        if (symbol == 'C') {
            calculatorExpressionCompiler.allClear();
            resp.getWriter().println(0);
        } else {
            updateCalculatorExpressionCompilerState(calculatorExpressionCompiler, operation);
            String result = calculatorExpressionCompiler.getCurrentAnswerAsString(symbol);
            boolean isSaved = false;
            if (operationReady(operation, result)) {
                operation.setOperationResult(result);
                isSaved = saveOperation(operation);
            }
            resp.getWriter().println(result);
            if (isSaved) {
                resp.sendError(500, "Operation not created");
            }
        }
    }

    private Operation getOperationByCookie(String cookie) {
        if (cookieOperationMap.containsKey(cookie)) {
            return cookieOperationMap.get(cookie);
        } else {
            return new Operation("", null, cookie);
        }
    }

    private void updateCalculatorExpressionCompilerState(CalculatorExpressionCompiler calculatorExpressionCompiler,
                                                         Operation operation) {
        char[] expression = operation.getOperationContent().toCharArray();
        for (char symbol : expression) {
            calculatorExpressionCompiler.getCurrentAnswerAsString(symbol);
        }
    }

    @SuppressWarnings(value = {"unchecked"})
    private boolean saveOperation(Operation operation) {
        cookieOperationMap.remove(operation.getCookie());
        RepositoryFacade repositoryFacade = new RepositoryFacade(DaoType.H2DAO, EntityType.OPERATION);
        return repositoryFacade.getService().create(operation);
    }

    private boolean operationReady(Operation operation, String intermediateResult) {
        return !operation.getOperationContent().contains(intermediateResult);
    }
}
