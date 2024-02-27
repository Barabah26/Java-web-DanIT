package org.example.web2.files_part1;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new HtmlServlet()), "/files");
        handler.addServlet(new ServletHolder(new CssServlet()), "/static0/2.css");
        handler.addServlet(new ServletHolder(new JsServlet()), "/static0/1.js");
        handler.addServlet(new ServletHolder(new JpgServlet()), "/static0/hp.jpg");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}


