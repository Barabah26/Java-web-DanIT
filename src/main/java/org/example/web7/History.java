package org.example.web7;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface History {

    void put(Item item);
    Iterable<Item> get();
    Iterable<Item> getFor(String user);

}
