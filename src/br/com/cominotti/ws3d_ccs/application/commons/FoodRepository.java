package br.com.cominotti.ws3d_ccs.application.commons;

import ws3dproxy.model.Thing;

import java.util.Set;

public interface FoodRepository {

    Set<Thing> findAllFoods();

    void saveFood(Thing food);

    void removeFood(String foodName);
}
