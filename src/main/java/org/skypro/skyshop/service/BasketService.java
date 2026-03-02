package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final ProductBasket productBasket;

    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void checkProduct(UUID id){

        Optional<Product> o = storageService.getProductById(id);

        if (o.isPresent()){
            throw new IllegalArgumentException();
        } else productBasket.addProduct(id);

    }

        public UserBasket getUserBasket() {


        List<BasketItem> basketItemList = productBasket.getBasket().entrySet().stream()
                .map(m ->
                        new BasketItem(storageService.getProductById(m.getKey()).
                                orElseThrow(() ->
                                        new IllegalArgumentException("Продукт по ID не найден: " + m.getKey())), m.getValue()))
                .collect(Collectors.toCollection(ArrayList::new));

        return new UserBasket(basketItemList);
    }
}
