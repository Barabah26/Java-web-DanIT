package org.example.web2.files_part1;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JpgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fileName = ResourceOps.resourceUnsafe("static0/hp.jpg");
        var path = Paths.get(fileName);

        try (ServletOutputStream os = resp.getOutputStream();) {
            Files.copy(path, os);
        }
    }
}
