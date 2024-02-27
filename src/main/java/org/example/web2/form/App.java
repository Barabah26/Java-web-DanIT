package org.example.web2.form;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(FormHandleServlet.class, "/form");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
