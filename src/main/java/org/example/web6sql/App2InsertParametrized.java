package org.example.web6sql;

import org.example.web3sql1.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

public class App2InsertParametrized {
    public static void main(String[] args) throws SQLException {
        //1. connection
        try (Connection conn = Database.mkConn()) {
            //2. Query statement
            String insert = """
                     insert into calculator(x, y, z, op, dt) 
                     VALUES (?,?,?,?,now());
                    """;
            conn.setAutoCommit(false);
//            PreparedStatement st = conn.prepareStatement(insert);
//            st.executeUpdate();
//            st.executeUpdate();
            Savepoint saved1 = conn.setSavepoint("bla-bla-bla");
            conn.rollback(saved1);
            conn.commit(); //if ok
            conn.rollback(); //exception
            int level = conn.getTransactionIsolation();
            conn.setTransactionIsolation(level);
        }
    }
}
