package org.example.web7;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Override
    public Iterable<Item> getFor(String user) {
        return data.stream().filter(x -> x.user().toString().equals(user)).toList();
    }

}
