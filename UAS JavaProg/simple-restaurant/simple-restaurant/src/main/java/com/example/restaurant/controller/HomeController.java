package com.example.restaurant.controller;

import com.example.restaurant.entity.User;
import com.example.restaurant.repository.GoodsRepository;
import com.example.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping("")
    public String home(User user){
        return "homes";
    }

    @PostMapping("next")
    public String next(@Valid User user, BindingResult result, Model model){
        userRepository.save(user);
        model.addAttribute("goods", goodsRepository.findAll());
        return "menuMakanan";
    }

}
