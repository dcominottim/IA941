package br.com.cominotti.ws3d_ccs.infrastructure.storage.foods;

import java.util.HashSet;
import java.util.Set;

public class InMemoryFoodStorage implements FoodStorage {

    private Set<String> storage = new HashSet<>();


    @Override
    public void put(String foodName) {
        storage.add(foodName);
    }

    @Override
    public Set<String> getAll() {
        return new HashSet<>(storage);
    }
}
