package br.com.cominotti.ws3d_ccs.domain.model.commons;

import ws3dproxy.model.Thing;
import ws3dproxy.util.Constants;

import java.util.function.Predicate;


public class ThingPredicates {

    public static Predicate<Thing> isNotCreature() {
        return thing ->
                thing.getCategory() != Constants.categoryCREATURE;
    }

    public static Predicate<Thing> isFood() {
        return thing ->
                thing.getCategory() == Constants.categoryFOOD ||
                        thing.getCategory() == Constants.categoryNPFOOD ||
                        thing.getCategory() == Constants.categoryPFOOD;
    }

    public static Predicate<Thing> nameEquals(String foodName) {
        return thing -> thing.getName().equals(foodName);
    }
}
