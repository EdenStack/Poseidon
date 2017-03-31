package com.tneciv.poseidon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tneciv on 2017/3/30.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String redirectToIndex() {
        return "index";
    }

}
