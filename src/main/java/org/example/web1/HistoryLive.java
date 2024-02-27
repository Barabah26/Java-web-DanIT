package org.example.web1;

import java.util.ArrayList;
import java.util.List;

public class HistoryLive implements History{

    private final List<Item> data = new ArrayList<>();
    @Override
    public void put(Item item) {
        data.add(item);
    }

    @Override
    public List<Item> get() {
        return data;
    }
}
