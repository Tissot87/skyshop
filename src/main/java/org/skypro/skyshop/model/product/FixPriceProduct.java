package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product{
    private static final int FIX_COST = 50;

    public FixPriceProduct(UUID id, String name) {
        super(id, name);
    }

    @Override
    public int getCost() {
        return FIX_COST;
    }

    @Override
    public String toString() {
        return getName() + ":" + " Фиксированная цена " + getCost();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public boolean isSpecial() {
        return true;
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
