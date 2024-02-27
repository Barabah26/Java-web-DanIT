package org.example.web2.template_table;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.example.web2.template_welcome.ResourceOps;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

public class TemplateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setDirectoryForTemplateLoading(new File(
            ResourceOps.resourceUnsafe("template")
        ));

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Pavlo");
        data.put("date", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        List<PriceLine> items = List.of(
                new PriceLine(1, "Iphone", 999.9),
                new PriceLine(2, "MacBook", 2456.9),
                new PriceLine(3, "MacBook Air", 3000.9)

        );

        data.put("items", items);

        try (PrintWriter pw = resp.getWriter()) {
            Template template = cfg.getTemplate("welcome.ftl");
            template.process(data, pw);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
