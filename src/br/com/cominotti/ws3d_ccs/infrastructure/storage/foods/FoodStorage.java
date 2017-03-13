package br.com.cominotti.ws3d_ccs.infrastructure.storage.foods;

import ws3dproxy.model.Thing;

import java.util.Set;

public interface FoodStorage {

    Set<Thing> getAll();

    void put(Thing food);

    void remove(String foodName);
}
