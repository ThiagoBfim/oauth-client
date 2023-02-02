package com.keycloak.oauthclient.controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/")
public class UserController {


    @GetMapping
    public String homePage(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/details")
    public String userDetails(@AuthenticationPrincipal DefaultOidcUser principal) {
        return principal.getUserInfo().getFullName() + "AccessToken:" + principal.getIdToken().getTokenValue();
    }

    @GetMapping("/teste")
    public void userDetails() {
        System.out.println("aaaa");
    }
}
