package org.example.web1;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.web1.servlets.CalcServlet;
import org.example.web1.servlets.HelloServlet;
import org.example.web1.servlets.HistoryServlet;
import org.example.web3sql1.Database;

import javax.servlet.http.HttpServlet;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();

        History history = new HistoryPostgres(Database.mkConn());
        HttpServlet calcServlet = new CalcServlet(history);
        HttpServlet historyServlet = new HistoryServlet(history);

        handler.addServlet(HelloServlet.class, "/hello");
        handler.addServlet(new ServletHolder(calcServlet), "/calc");
        handler.addServlet(new ServletHolder(historyServlet), "/history");


        server.setHandler(handler);

        server.start();
        server.join();

    }
}
