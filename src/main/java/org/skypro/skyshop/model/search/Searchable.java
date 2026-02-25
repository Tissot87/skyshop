package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable extends Comparable {

    UUID getId();

    String getName();

    String getContentType();

    String searchTerm();

    String contentType();

    default String getStringRepresentation(){
        return this.searchTerm() + " - " + this.contentType();
    }

}
