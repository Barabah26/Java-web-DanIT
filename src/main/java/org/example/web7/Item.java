package org.example.web7;

import java.time.LocalDateTime;
import java.util.UUID;

public record Item(int x, int y, int z, String op, UUID user, LocalDateTime d) {

    public static Item make(int x, int y, int z, String op, UUID user){
        return new Item(x, y, z, op, user, LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "%d %s %d = %d @ %s u:%s".formatted(x, op, y, z, d, user.toString());
    }

//    static Item fromRS(ResultSet rs) throws SQLException {
//        int x = rs.getInt("x");
//        int y = rs.getInt("y");
//        int z = rs.getInt("z");
//        String op = rs.getString("op");
//        LocalDateTime dt = rs.getObject("dt", LocalDateTime.class);
//        return new Item(x, y, z, op, dt);
//    }
}
