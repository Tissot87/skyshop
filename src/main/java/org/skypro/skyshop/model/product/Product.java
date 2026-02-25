package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {

    private final String name;

    public Product(String name) throws IllegalArgumentException{

        this.name = name;
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public abstract int getCost();

    public abstract boolean isSpecial();


    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public String getContentType() {
        return "";
    }

    @Override
    public String contentType() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

