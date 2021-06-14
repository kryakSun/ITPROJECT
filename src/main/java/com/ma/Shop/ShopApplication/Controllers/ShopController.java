package com.ma.Shop.ShopApplication.Controllers;
import com.ma.Shop.ShopApplication.models.Post;
import com.ma.Shop.ShopApplication.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ShopController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/shop")
    public String home(Model model) {
        Iterable<Post> posts = postRepository.findAll();                      // array, where DB data will be store
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/shop/add")
    public String createAdPage(Model model) {
        return "createAd";
    }

    @GetMapping("/shop/profile")
    public String profile(Model model) {
        return "profile";
    }

    @PostMapping("/shop/add")
    public String createAd(@RequestParam String title,@RequestParam String fullText, @RequestParam int price, Model model) {
        Post post = new Post(title, fullText, price);
        postRepository.save(post);
        return "redirect:/shop";
    }

    @GetMapping("/shop/{id}")
    public String adReview(@PathVariable(value = "id") long id, Model model) {
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "adReview";
    }

}
