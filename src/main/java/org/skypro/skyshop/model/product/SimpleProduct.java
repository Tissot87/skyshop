package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    public int cost;

    @Override
    public String getName() {
        return super.getName();
    }

    public SimpleProduct(UUID id, String name, int cost) throws IllegalArgumentException {
        super(id, name);
        if ((this.cost = cost) < 1){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ":" + getCost();
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public UUID getId() {
        return null;
    }
}
