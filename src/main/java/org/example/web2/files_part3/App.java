package org.example.web2.files_part3;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new StaticFileServlet("static0")), "/static/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}

