package com.tneciv.poseidon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tneciv on 2017/3/31.
 */
@RestController
public class LoginController {

    @RequestMapping("/")
    public String auth() {
        return "hello world .";
    }

    @RequestMapping("/users")
    public String getUsers() {
        return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
    }

}
