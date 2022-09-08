package com.eggnews.eggnews.controller;

import com.eggnews.eggnews.exception.MyException;
import com.eggnews.eggnews.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    // TODO: recibir imagen
    @PostMapping("/create")
    public String create(@RequestParam String title, String body, ModelMap model) throws MyException{
        String img = "";
        try {
            newService.saveNew(title, body, img);
            model.put("exito", "La noticia fue cargada correctamente");
        } catch (MyException e) {
            model.put("error", e.getMessage());
            return "new_form.html";
        }
        return "index.html";
    }
}
