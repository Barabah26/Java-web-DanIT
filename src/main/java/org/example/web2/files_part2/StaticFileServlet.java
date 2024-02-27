package org.example.web2.files_part2;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StaticFileServlet extends HttpServlet {

    private final String fileName;

    public StaticFileServlet(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fileNameInResources = ResourceOps.resourceUnsafe(fileName);
        var path = Paths.get(fileNameInResources);

        try (ServletOutputStream os = resp.getOutputStream()) {
            Files.copy(path, os);
        }
    }
}
