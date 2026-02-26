package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product{
    public int baseCost;

    public int discount;

    @Override
    public String getName() {
        return super.getName();
    }

    public DiscountedProduct(UUID id, String name, int baseCost, int discount) throws IllegalArgumentException {
        super(id, name);
        if ((this.baseCost = baseCost) < 1){
            throw new IllegalArgumentException();
        }
        this.discount = discount;
        if (discount < 0 || discount > 100){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getCost() {
        if (0 < discount && discount <100) {
            return baseCost - (baseCost/100*discount);
        }else {return -1;}
    }

    @Override
    public String toString() {
        return getName() + ":" + getCost() + " (скидка) " + discount + "%";
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
