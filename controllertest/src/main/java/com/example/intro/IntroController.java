package com.example.intro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IntroController {
    @GetMapping("/intro/content")
    public String IntroPage(@RequestParam(name = "name", defaultValue = "intro test") String name, Model model) {
        model.addAttribute("name", name);
        return "/intro/content";
    }
}
