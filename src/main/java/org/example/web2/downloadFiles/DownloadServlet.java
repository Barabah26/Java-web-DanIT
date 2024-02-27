package org.example.web2.downloadFiles;

import org.example.web2.files_part3.ResourceOps;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadServlet extends HttpServlet {

    private final String fileName;

    public DownloadServlet(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fullName = ResourceOps.resourceUnsafe(fileName);

        if(!new File(fullName).exists()) {
            resp.setStatus(404);
        } else try (ServletOutputStream os = resp.getOutputStream()) {
            Path path = Paths.get(fullName);

            resp.setContentType("application/x-binary");
            resp.setHeader("Content-disposition", "attachment; filename=F_123.jpg");

            Files.copy(path, os);


        }
    }
}
