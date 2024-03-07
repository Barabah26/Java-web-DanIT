package org.example.web7;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


import javax.servlet.http.HttpServlet;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();

        FreemarkerService freemarker = new FreemarkerService("static0/templates");

        History history = new HistoryLive();

        HttpServlet loginServlet = new LoginServlet(freemarker);
        HttpServlet logoutServlet = new LogoutServlet(freemarker);
        HttpServlet calcServlet = new CalcServlet(freemarker, history);
        HttpServlet historyServlet = new HistoryServlet(history);

        handler.addServlet(new ServletHolder(loginServlet), "/login");
        handler.addServlet(new ServletHolder(logoutServlet), "/logout");
        handler.addServlet(new ServletHolder(calcServlet), "/calc");
        handler.addServlet(new ServletHolder(historyServlet), "/history");


        server.setHandler(handler);

        server.start();
        server.join();

    }
}
