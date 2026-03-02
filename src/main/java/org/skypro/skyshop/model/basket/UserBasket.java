package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.service.StorageService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserBasket {

    private final List<BasketItem> basketItemList;

    public UserBasket(List<BasketItem> basketItemList) {
        this.basketItemList = basketItemList;
    }

    private double total;

    public double getTotal(){
        total = basketItemList.stream()
                .mapToDouble(m -> m.getProduct().getCost()*m.getCount())
                .sum();
        return total;
    }

}
