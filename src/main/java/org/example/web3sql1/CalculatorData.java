package org.example.web3sql1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

public record CalculatorData(Integer x, Integer y, Integer z, String op, LocalDateTime dt) {

    static CalculatorData fromRS(ResultSet rs) throws SQLException {
        Integer x = rs.getInt("x");
        Integer y = rs.getInt("y");
        Integer z = rs.getInt("z");
        String op = rs.getString("op");
        LocalDateTime dt = rs.getObject("dt", LocalDateTime.class);
        return new CalculatorData(x, y, z, op, dt);
    }
}
