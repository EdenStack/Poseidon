package com.tneciv.poseidon.controller;

import com.tneciv.poseidon.common.LoginUser;
import com.tneciv.poseidon.security.AccountCredentials;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tneciv on 2017/3/31.
 */
@RestController
public class LoginController {

    /**
     * For test auth in header .
     *
     * @return
     */
    @RequestMapping("/users")
    public String getUsers(@LoginUser AccountCredentials account) {
        String username = account.getUsername();
        return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
    }

}
