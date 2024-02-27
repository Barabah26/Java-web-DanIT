package org.example.web1.servlets;

import org.example.web1.History;
import org.example.web1.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {

    private final History history;

    public CalcServlet(History history) {
        this.history = history;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String xs = req.getParameter("x");
        String ys = req.getParameter("y");
        String op = req.getParameter("op");

        int x = Integer.parseInt(xs);
        int y = Integer.parseInt(ys);

        record Result(int result, String show){}

        Result z = switch (op){
            case "add" -> new Result(x + y, "+");
            case "sub" -> new Result(x - y, "-");
            case "mul" -> new Result(x * y, "*");
            case "div" -> new Result(x / y, "/");
            default -> throw new IllegalStateException("something unexpected");
        };

        history.put(Item.make(x, y, z.result, z.show));

        String outcome = String.format("%d %s %d = %d", x, z.show, y, z.result);

        try(PrintWriter pw = resp.getWriter()) {
            pw.println(outcome);
        }


    }
}
