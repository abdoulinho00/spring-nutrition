package com.aelbardai.medidoc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aelbardai.medidoc.beans.article.Article;
import com.aelbardai.medidoc.beans.article.ArticleType;
import com.aelbardai.medidoc.beans.diet.MenuItem;
import com.aelbardai.medidoc.service.ArticleService;
import com.aelbardai.medidoc.service.MenuItemService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("roles")
public class AdminController {

    private static final Logger logger = Logger.getLogger(AdminController.class);
    @Autowired
    MenuItemService menuItemService;
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String adminControlPanel(ModelMap model) {

        return "admin/view";
    }

    /*
     * Methods of menu items management
     */
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String listMenu(ModelMap model) {
        List<MenuItem> menuItems = menuItemService.getAllMenuItem();
        model.addAttribute("menuItems", menuItems);
        return "admin/menu_maker/list";
    }

    @RequestMapping(value = "/menu/add", method = RequestMethod.GET)
    public String addEditMenu(@RequestParam(value = "id", required = false) Long id, ModelMap model) {
        MenuItem menuItem;
        if (id != null && id > 0) {
            menuItem = menuItemService.getMenuItem(id);
            if (menuItem == null) {
                menuItem = new MenuItem();
            }
        } else {
            menuItem = new MenuItem();
        }
        model.addAttribute("menuItem", menuItem);
        return "admin/menu_maker/add-edit";
    }

    @RequestMapping(value = "/menu/add", method = RequestMethod.POST)
    public String submitMenuForm(MenuItem menuItem, BindingResult result) {
        if (menuItem == null) {
            logger.error("object is not initialized");
        } else {
            if (menuItem.getId() > 0) {
                menuItemService.updateMenuItem(menuItem);
            } else {
                menuItemService.addMenuItem(menuItem);
            }
        }
        return "redirect:/admin/menu";
    }

    @RequestMapping("/menu/remove")
    public String removeMenuItem(@RequestParam("id") long id) {
        menuItemService.deleteMenuItem(id);
        return "redirect:/admin/menu";
    }

    /*
     * Articles admin section
     * 
     */
    @RequestMapping("/articles")
    public String listArticles(Model model) {
        List<Article> articles = articleService.getAllArticle();
        model.addAttribute("articles", articles);
        return "admin/article/list";
    }

    @RequestMapping("/articles/add")
    public String addEditArticleForm(@RequestParam(value = "id", required = false) Long id, Model model) {
        Article article;
        if (id != null && id > 0) {
            article = articleService.getArticleById(id);
            if (article == null) {
                article = new Article();
            }
        } else {
            article = new Article();
        }
        model.addAttribute("types", ArticleType.values());
        model.addAttribute("article", article);
        return "admin/article/addEdit";
    }

    @RequestMapping(value = "/articles/add", method = RequestMethod.POST)
    public String addEditArticle(Article article, BindingResult result) {
        if (article.getId() > 0) {
            articleService.updateArticle(article);
        } else {
            articleService.addArticle(article);
        }
        return "redirect:/admin/articles";
    }

    public String removeArticle(@RequestParam("id") long id) {
        if (id > 0) {
            articleService.deleteArticle(id);
        }
        return "redirect:/admin/articles";
    }

}
