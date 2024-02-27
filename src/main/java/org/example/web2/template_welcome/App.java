package org.example.web2.template_welcome;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new TemplateServlet()), "/template");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
