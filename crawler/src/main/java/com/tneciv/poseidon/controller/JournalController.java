package com.tneciv.poseidon.controller;

import com.tneciv.poseidon.common.ResEnv;
import com.tneciv.poseidon.entity.Journal;
import com.tneciv.poseidon.service.JournalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResEnv<List<Journal>> queryById(@PathVariable("id") Integer id) {
        List<Journal> journalList = null;
        try {
            journalList = journalService.queryByJournalId(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return ResEnv.fail(e, HttpStatus.BAD_REQUEST);
        }
        return ResEnv.success(journalList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/keyword/{keyword}")
    public ResEnv<List<Journal>> queryListByKeyword(@PathVariable("keyword") String keyword) {
        List<Journal> journalList = journalService.queryByKeyWord(keyword);
        return ResEnv.success(journalList);
    }

    @GetMapping("/title/{title}")
    public ResEnv<List<Journal>> queryListByTitle(@PathVariable("title") String title) {
        List<Journal> journalList = journalService.queryByLikeTitles(title);
        return ResEnv.success(journalList, HttpStatus.ACCEPTED);
    }

}
