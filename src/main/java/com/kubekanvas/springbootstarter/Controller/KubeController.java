package com.kubekanvas.springbootstarter.Controller;


import com.kubekanvas.springbootstarter.Service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class KubeController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/")
    public String pageOne() {
        return "page1";
    }

    @GetMapping("/welcome")
    public String pageTwo(@RequestParam String name, Model model) {
        model.addAttribute("userName", name);
        return "page2";
    }

    @GetMapping("/links")
    public String pageThree(Model model) {
        model.addAttribute("links", linkService.getAllLinks());
        return "page3";
    }
}