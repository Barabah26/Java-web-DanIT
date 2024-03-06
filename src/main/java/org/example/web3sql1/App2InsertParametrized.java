package org.example.web3sql1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App2InsertParametrized {
    public static void main(String[] args) throws SQLException {
        //1. connection
        try (Connection conn = Database.mkConn()) {

            //2. Query statement
            String insert = """
                     
                     insert into calculator(x, y, z, op, dt) 
                     VALUES (?,?,?,?,now());
                       

                    """;
            //3. compile / prepare
            PreparedStatement st = conn.prepareStatement(insert);

            //4. set parameters
            st.setInt(1, 100);
            st.setInt(2, 100);
            st.setInt(3, 200);
            st.setString(4, "add");

            //5. run
            int n = st.executeUpdate();
            System.out.printf("%d record inserted", n);

        }
    }
}
