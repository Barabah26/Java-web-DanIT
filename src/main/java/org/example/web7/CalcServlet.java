package org.example.web7;

import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CalcServlet extends HttpServlet {
    private final FreemarkerService freemarker;
    private final History history;

    public CalcServlet(FreemarkerService freemarker, History history) throws IOException {
        this.freemarker = freemarker;
        this.history = history;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Auth.getCookieValue(req)
                .ifPresentOrElse(
                        user -> {
                            HashMap<String, Object> data = new HashMap<>();
                            data.put("user_id", user);

                            try (PrintWriter w = resp.getWriter()) {
                                freemarker.render("calc-form.ftl", data, w);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> Auth.renderUnregistered(resp)

                );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Auth.getCookieValue(req)
                .ifPresentOrElse(
                        user -> {
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

                            Item item = Item.make(x, y, z.result, z.show, UUID.fromString(user));
                            history.put(item);

                            HashMap<String, Object> data = new HashMap<>();
                            data.put("user_id", user);
                            data.put("result", item.toString());

                            try(PrintWriter w = resp.getWriter()){
                                Auth.setCookieValue(user, resp);
                                freemarker.render("calc-result.ftl", data, w);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> Auth.renderUnregistered(resp)

                );


    }
}
