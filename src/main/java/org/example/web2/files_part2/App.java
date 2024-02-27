package org.example.web2.files_part2;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new StaticFileServlet("static0/3.html")), "/files");
        handler.addServlet(new ServletHolder(new StaticFileServlet("static0/2.css")), "/static0/2.css");
        handler.addServlet(new ServletHolder(new StaticFileServlet("static0/1.js")), "/static0/1.js");
        handler.addServlet(new ServletHolder(new StaticFileServlet("static0/hp.jpg")), "/static0/hp.jpg");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}

