package org.example.web3sql1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class App3Select {
    public static void main(String[] args) throws SQLException {
        //1. connection
        try (Connection conn = Database.mkConn()) {

            //2. Query statement
            String select = """
                     
                     select x, y, z, op, dt 
                     from calculator;
                       

                    """;
            //3. compile / prepare
            PreparedStatement st = conn.prepareStatement(select);



            //5. run
            ResultSet rs = st.executeQuery();
            ArrayList<CalculatorData> xs = new ArrayList<>();
            while (rs.next()){
                xs.add(CalculatorData.fromRS(rs));

            }

            xs.forEach(System.out::println);
        }
    }
}
