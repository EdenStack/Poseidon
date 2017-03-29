package com.tneciv.poseidon.controller;

import com.tneciv.poseidon.common.ResponseBody;
import com.tneciv.poseidon.entity.Journal;
import com.tneciv.poseidon.service.JournalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tneciv on 2017/3/26.
 */
@RestController
@RequestMapping("/journal")
@Slf4j
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseBody<List<Journal>> queryById(@PathVariable("id") Integer id) {
        List<Journal> journalList = journalService.queryByJournalId(id);
        int i = 1 / 0;
        return ResponseBody.success(journalList);
    }

    @GetMapping("/keyword/{keyword}")
    public ResponseBody<List<Journal>> queryListByKeyword(@PathVariable("keyword") String keyword) {
        List<Journal> journalList = journalService.queryByKeyWord(keyword);
        return ResponseBody.success(journalList);
    }

    @GetMapping("/title/{title}")
    public ResponseBody<List<Journal>> queryListByTitle(@PathVariable("title") String title) {
        List<Journal> journalList = journalService.queryByLikeTitles(title);
        return ResponseBody.success(journalList);
    }

}
