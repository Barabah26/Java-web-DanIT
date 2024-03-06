package org.example.web1;

import org.example.web3sql1.CalculatorData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public record Item(int x, int y, int z, String op, LocalDateTime d) {

    public static Item make(int x, int y, int z, String op){
        return new Item(x, y, z, op, LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "%d %s %d = %d @ %s}".formatted(x, op, y, z, d);
    }

    static Item fromRS(ResultSet rs) throws SQLException {
        int x = rs.getInt("x");
        int y = rs.getInt("y");
        int z = rs.getInt("z");
        String op = rs.getString("op");
        LocalDateTime dt = rs.getObject("dt", LocalDateTime.class);
        return new Item(x, y, z, op, dt);
    }
}
