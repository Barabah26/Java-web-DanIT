package org.example.web1;

import java.util.List;

public interface History {

    void put(Item item);
    List<Item> get();

}
