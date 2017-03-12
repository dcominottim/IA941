package br.com.cominotti.ws3d_ccs.infrastructure.storage.foods;

import java.util.Set;

public interface FoodStorage {

    void put(String foodName);

    Set<String> getAll();
}
