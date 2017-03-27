package com.tneciv.poseidon.controller;

import com.tneciv.poseidon.service.CrawlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tneciv on 2017/3/26.
 */
@RestController
@RequestMapping("/journal")
public class JournalController {

    private static final Logger logger = LoggerFactory.getLogger(JournalController.class);

    @Autowired
    private CrawlerService crawlerService;

    @PostMapping
    public ResponseEntity createJournal(@RequestParam("id") Integer id) {
        try {
            crawlerService.handle(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Insert succ .", HttpStatus.ACCEPTED);
    }
}
