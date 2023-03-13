package ru.putilin.springbootrest.controller;

import org.springframework.web.bind.annotation.*;
import ru.putilin.springbootrest.model.Authorities;
import ru.putilin.springbootrest.model.MyNewUser;
import ru.putilin.springbootrest.model.User;
import ru.putilin.springbootrest.service.AuthorizationService;

import java.util.List;

@RestController

public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@MyNewUser User user) {
        return service.getAuthorities(user);
    }

}
