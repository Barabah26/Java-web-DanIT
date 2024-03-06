package org.example.web1;

import java.sql.SQLException;
import java.util.List;

public interface History {

    void put(Item item) throws SQLException;
    List<Item> get() throws SQLException;

}
