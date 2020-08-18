package com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(Model model) {

        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logoutSuccessfulPage(Model model) {
        //model.addAttribute("title", "Logout");
        return "redirect:/login";
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/";
        } else if (request.isUserInRole("ROLE_USER")) {
            return "redirect:/user/";
        } else return "redirect:/login";
    }
}
