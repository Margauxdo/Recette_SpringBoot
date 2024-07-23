package org.example.recette_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    public HomepageController() {


    }
    @GetMapping("/")
    public String homepage() {
        return "homePage";
    }
}
