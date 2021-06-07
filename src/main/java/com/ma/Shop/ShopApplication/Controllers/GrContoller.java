package com.ma.Shop.ShopApplication.Controllers;
import com.ma.Shop.ShopApplication.models.Post;
import com.ma.Shop.ShopApplication.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GrContoller {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/home")
    public String home(Model model) {
        Iterable<Post> posts = postRepository.findAll();                      // array, where DB data will be store
        model.addAttribute("posts", posts);
        return "index";
    }
}
