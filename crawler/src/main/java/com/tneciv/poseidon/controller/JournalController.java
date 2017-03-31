package com.tneciv.poseidon.controller;

import com.tneciv.poseidon.common.ResponseBody;
import com.tneciv.poseidon.dto.JournalDto;
import com.tneciv.poseidon.entity.Journal;
import com.tneciv.poseidon.service.JournalService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "获取期刊详细信息", notes = "根据url的id来获取期刊详细信息")
    @ApiImplicitParam(name = "id", value = "期刊ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseBody<JournalDto> queryById(@PathVariable("id") Integer id) {
        JournalDto journalDto = journalService.queryByJournalId(id);
        return ResponseBody.success(journalDto);
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
