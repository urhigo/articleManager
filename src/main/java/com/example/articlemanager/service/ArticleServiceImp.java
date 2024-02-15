package com.example.articlemanager.service;

import com.example.articlemanager.model.Article;
import com.example.articlemanager.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleServiceImp implements ArticleService{

    final
    ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImp(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Iterable<Article> allArticle() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> findOneById(long id) {
        return articleRepository.findById(id);
    }

    @Override
    public void addNewArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticleById(long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void editArticle(Article article) {
        articleRepository.save(article);
    }
}
