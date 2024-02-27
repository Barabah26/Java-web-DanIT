package org.example.web1;

import java.time.LocalDateTime;

public record Item(int x, int y, int z, String op, LocalDateTime d) {

    public static Item make(int x, int y, int z, String op){
        return new Item(x, y, z, op, LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "%d %s %d = %d @ %s}".formatted(x, op, y, z, d);
    }
}
