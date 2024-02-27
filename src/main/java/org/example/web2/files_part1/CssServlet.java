package org.example.web2.files_part1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CssServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fileName = ResourceOps.resourceUnsafe("static0/2.css");
        var path = Paths.get(fileName);

        try (PrintWriter w = resp.getWriter()) {
            Files.readAllLines(path).forEach(w::println);
        }
    }
}
