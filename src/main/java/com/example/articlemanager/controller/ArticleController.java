package com.example.articlemanager.controller;

import com.example.articlemanager.model.Article;
import com.example.articlemanager.service.ArticleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/article")
public class ArticleController {

    final
    ArticleServiceImp articleServiceImp;

    @Autowired
    public ArticleController(ArticleServiceImp articleServiceImp) {
        this.articleServiceImp = articleServiceImp;
    }

    @GetMapping
    public String homePage(Model model){
        model.addAttribute("articles", articleServiceImp.allArticle());
        return "homePage";
    }

    @GetMapping("/{id}")
    public String article(@PathVariable(name = "id") long id, Model model){
        model.addAttribute("article", articleServiceImp.findOneById(id).get());
        return "article";
    }

    @GetMapping("/addArticle")
    public String addArticleForm(){
        return "addArticle";
    }

    @PostMapping("/addArticle")
    public RedirectView addNewArticle(@RequestParam String title, @RequestParam String content,
                                      @RequestParam String author){
        articleServiceImp.addNewArticle(new Article(title, content, author));
        return new RedirectView("/article");
    }

    @GetMapping("/{id}/edit")
    public String editArticle(@PathVariable (name = "id") long id, Model model){
        model.addAttribute("article", articleServiceImp.findOneById(id).get());
        return "editArticle";
    }

    @PostMapping("/{id}/edit")
    public RedirectView editArticleSave(@PathVariable (name = "id") long id,
                                        @RequestParam String title, @RequestParam String content,
                                        @RequestParam String author){
        articleServiceImp.editArticle(new Article(id, title, content, author));
        return new RedirectView("/article/" + id);
    }


    @PostMapping("/{id}/delete")
    public RedirectView deleteArticle(@PathVariable (name = "id") long id){
        articleServiceImp.deleteArticleById(id);
        return new RedirectView("/article");
    }
}
