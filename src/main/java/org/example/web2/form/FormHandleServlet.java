package org.example.web2.form;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FormHandleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = ResourceOps.resourceUnsafe("calc-form.html");

        if (!new File(fileName).exists()){
            resp.setStatus(404);
        } else try(ServletOutputStream os = resp.getOutputStream()) {
            Path path = Paths.get(fileName);
            Files.copy(path, os);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xs = req.getParameter("x");
        String ys = req.getParameter("y");
        String ops = req.getParameter("op");

        try (PrintWriter pw = resp.getWriter()){
            pw.printf(" x = %s ", xs);
            pw.printf(" y = %s ", ys);
            pw.printf(" op = %s ", ops);

        }

    }
}
