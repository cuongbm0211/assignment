package com.example.cuongstarterkit.application.api.controller;

import com.example.cuongstarterkit.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tokens")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @GetMapping
    public String listAccessTokens(Model model) {
        model.addAttribute("listTokens", tokenService.listAccessTokens());
        return "token/list-token";
    }

    @PostMapping("/revoke/{tokenId}")
    public String listAccessTokens(Model model, @PathVariable(name = "tokenId") String tokenId) {
        tokenService.revoke(tokenId);

        model.addAttribute("listTokens", tokenService.listAccessTokens());
        return "token/list-token";
    }
}
