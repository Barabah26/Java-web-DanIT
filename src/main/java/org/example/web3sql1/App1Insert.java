package org.example.web3sql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App1Insert {
    public static void main(String[] args) throws SQLException {
        Connection conn = Database.mkConn();

        //insert
        String insert = """
                insert into calculator(x, y, z, op, dt) 
                VALUES (1,10,11,'add',now());
                """;

        PreparedStatement st = conn.prepareStatement(insert);
        int n = st.executeUpdate();
        System.out.printf("%d record inserted", n);

        conn.close();
    }
}
