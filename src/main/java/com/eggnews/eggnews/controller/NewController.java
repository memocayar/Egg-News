package com.eggnews.eggnews.controller;

import com.eggnews.eggnews.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/new")
public class NewController {

    @Autowired
    private NewService newService;

    @GetMapping("/form")
    public String form(){
        return "new_form.html";
    }

    @PostMapping("/create")
    public String create(@RequestParam String title, String body){
        // TODO: cambiar para que reciba imagen
        // TODO: TRY CATCH
        String img = "";
        newService.saveNew(title, body, img);
        return "index.html";
    }
}
