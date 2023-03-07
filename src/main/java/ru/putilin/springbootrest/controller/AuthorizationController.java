package ru.putilin.springbootrest.controller;

import org.springframework.web.bind.annotation.*;
import ru.putilin.springbootrest.Authorities;
import ru.putilin.springbootrest.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

}
