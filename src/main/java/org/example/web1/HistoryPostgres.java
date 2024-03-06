package org.example.web1;

import org.example.web3sql1.CalculatorData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryPostgres implements History{
    private final Connection conn;

    public HistoryPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void put(Item i) throws SQLException {
        String insert = """
                     
                     insert into calculator(x, y, z, op, dt) 
                     VALUES (?,?,?,?,now());
                       

                    """;
        //3. compile / prepare
        PreparedStatement st = conn.prepareStatement(insert);

        //4. set parameters
        st.setInt(1, i.x());
        st.setInt(2, i.y());
        st.setInt(3, i.z());
        st.setString(4, i.op());

        //5. run
        st.executeUpdate();
    }

    @Override
    public List<Item> get() throws SQLException {
        String select = """
                     
                     select x, y, z, op, dt 
                     from calculator;
                       

                    """;
        //3. compile / prepare
        PreparedStatement st = conn.prepareStatement(select);



        //5. run
        ResultSet rs = st.executeQuery();
        ArrayList<Item> xs = new ArrayList<>();
        while (rs.next()){
            xs.add(Item.fromRS(rs));

        }
        return xs;
    }
}
