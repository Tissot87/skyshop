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

    private final int total;

    public UserBasket(List<BasketItem> basketItemList, int total) {
        this.basketItemList = basketItemList;

        int calculateTotalSum = basketItemList.stream()
                    .mapToInt(m -> m.getProduct().getCost()*m.getCount())
                    .sum();

        this.total = calculateTotalSum;
    }

    public List<BasketItem> getBasketItemList() {
        return basketItemList;
    }

    public int getTotal() {
        return total;
    }
}
