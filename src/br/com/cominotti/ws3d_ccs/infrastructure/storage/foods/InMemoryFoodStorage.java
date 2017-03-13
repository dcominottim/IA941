package br.com.cominotti.ws3d_ccs.infrastructure.storage.foods;

import ws3dproxy.model.Thing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InMemoryFoodStorage implements FoodStorage {

    private Map<String, Thing> storage = new HashMap<>();


    @Override
    public Set<Thing> getAll() {
        return new HashSet<>(storage.values());
    }

    @Override
    public void put(Thing food) {
        storage.put(food.getName(), food);
    }

    @Override
    public void remove(String foodName) {
        storage.remove(foodName);
    }
}
