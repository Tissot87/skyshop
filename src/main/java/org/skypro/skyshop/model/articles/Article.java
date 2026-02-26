package org.skypro.skyshop.model.articles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {

    private final UUID id;

    private final String articleName;

    private final String articleText;


    public Article(UUID id, String articleName, String articleText) {
        this.id = id;
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return articleName + "/n" + articleText;
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public String getName() {
        return articleName.toString();
    }

    @Override
    @JsonIgnore
    public String getContentType() {
        return contentType().toString();
    }

    @Override
    @JsonIgnore
    public String getSearchTerm() {
        return this.toString();
    }

    @Override
    public String contentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleName);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
