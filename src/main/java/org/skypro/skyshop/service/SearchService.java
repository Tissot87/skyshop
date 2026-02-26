package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }


    public ArrayList<SearchResult> searchResult(String findingTerm){

        return storageService
                .searchableCollection()
                .stream()
                .filter(item -> item.getSearchTerm()
                        .toLowerCase()
                        .contains(findingTerm.toLowerCase()))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}