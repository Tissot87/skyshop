package org.skypro.skyshop.service;

import org.skypro.skyshop.model.articles.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {

    private final Map<UUID, Product> mapOfProducts;

    private final Map<UUID, Article> mapOfArticles;



    public StorageService(Map<UUID, Product> product, Map<UUID, Article> article){
        this.mapOfProducts = product;
        this.mapOfArticles = article;
    }

    public Collection<Product> getAllProducts(){
        return mapOfProducts.values();
    }

    public Collection<Article> getAllArticles(){
        return mapOfArticles.values();
    }

    public List<Searchable> searchableCollection(){

        List<Searchable> list = new ArrayList<>();
        list.add((Searchable) getAllArticles());
        list.add((Searchable) getAllProducts());
        return list;

    }

}


