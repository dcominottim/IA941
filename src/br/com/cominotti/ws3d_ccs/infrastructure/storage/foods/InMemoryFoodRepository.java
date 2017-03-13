package br.com.cominotti.ws3d_ccs.infrastructure.storage.foods;

import br.com.cominotti.ws3d_ccs.application.commons.FoodRepository;
import ws3dproxy.model.Thing;

import java.util.Set;

public class InMemoryFoodRepository implements FoodRepository {

    private final InMemoryFoodStorage storage;


    public InMemoryFoodRepository(final InMemoryFoodStorage storage) {
        this.storage = storage;
    }


    @Override
    public Set<Thing> findAllFoods() {
        return storage.getAll();
    }

    @Override
    public void saveFood(Thing food) {
        storage.put(food);
    }

    @Override
    public void removeFood(String foodName) {
        storage.remove(foodName);
    }
}
