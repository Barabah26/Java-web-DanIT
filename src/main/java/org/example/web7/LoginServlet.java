package org.example.web7;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

public class LoginServlet extends HttpServlet {

    private final FreemarkerService freemarker;

    public LoginServlet(FreemarkerService freemarker) {
        this.freemarker = freemarker;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message1 = Auth.getCookieValue(req)
                .map(id -> String.format("User %s was logged out", id))
                .orElse("Nobody was logged");

        String id = UUID.randomUUID().toString();

        String message2 = String.format("User %s logged in", id);

        HashMap<String, Object> data = new HashMap<>();
        data.put("message1", message1);
        data.put("message2", message2);

        try(PrintWriter w = resp.getWriter()){
            Auth.setCookieValue(id, resp);
            freemarker.render("calc-login.ftl", data, w);
        }

    }
}
