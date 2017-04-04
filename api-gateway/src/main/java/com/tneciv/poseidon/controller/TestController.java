package com.tneciv.poseidon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tneciv on 2017/4/4.
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test cors";
    }

}
