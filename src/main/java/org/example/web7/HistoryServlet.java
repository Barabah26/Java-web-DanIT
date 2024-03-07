package org.example.web7;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class HistoryServlet extends HttpServlet {

    private final History history;

    public HistoryServlet(History history) {
        this.history = history;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Auth.getCookieValue(req)
                .ifPresentOrElse(
                        user -> {
                            try (PrintWriter pw = resp.getWriter()){
                                history.getFor(user)
                                        .forEach(pw::println);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> Auth.renderUnregistered(resp)
                );


    }
}
