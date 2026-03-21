package org.skypro.skyshop.model.basket;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SessionScope
@Component
public class ProductBasket {

    private final Map<UUID, Integer> mapOfProducts;
    public ProductBasket(Map<UUID, Integer> mapOfProducts) {
        this.mapOfProducts = mapOfProducts;
    }

    public void addProduct(UUID id){


        mapOfProducts.computeIfAbsent(id, k -> {int i = 1;
            return i++;
        });
    }

    public Map<UUID, Integer> getBasket() {
        return Collections.unmodifiableMap(mapOfProducts);
    }

}
