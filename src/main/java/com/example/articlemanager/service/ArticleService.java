package com.example.articlemanager.service;

import com.example.articlemanager.model.Article;

import java.util.Optional;

public interface ArticleService {

    Iterable<Article> allArticle();
    Optional<Article> findOneById(long id);
    void addNewArticle(Article article);
    void deleteArticleById(long id);
    void editArticle(Article article);
}
