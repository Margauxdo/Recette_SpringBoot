package org.example.recette_springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class HomepageController {

    public HomepageController() {


    }
    @GetMapping("/")
    public String homepage() {
        return "homePage";
    }

    @GetMapping("/pb")
    public String pb(){
        if (true) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }
        return "homePage";
    }
}
