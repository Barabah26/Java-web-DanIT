package org.example.web2.files_part3;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StaticFileServlet extends HttpServlet {

    private final String root;

    public StaticFileServlet(String root) {
        this.root = root;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String prefix = ResourceOps.resourceUnsafe(root);
        System.out.println(prefix);

        String fileName = req.getPathInfo();  // це те, що йде після "/"
        System.out.println(fileName);

        String fullName = prefix + fileName;
        System.out.println(fullName);

        if(!new File(fullName).exists()) {
            resp.setStatus(404);
        } else try (ServletOutputStream os = resp.getOutputStream()) {
            Path path = Paths.get(fullName);
            Files.copy(path, os);
        }
    }
}
