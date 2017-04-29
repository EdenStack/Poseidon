package com.tneciv.poseidon.controller;

import com.tneciv.poseidon.common.PageVo;
import com.tneciv.poseidon.common.ResponseBody;
import com.tneciv.poseidon.dto.JournalDto;
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

    @GetMapping("/keyword")
    public PageVo<JournalDto> queryListByKeyword(@RequestParam("q") String keyword,
                                                 @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                                 @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        pageSize = pageSize == null ? 0 : pageSize;
        pageNum = pageNum == null ? 1 : pageNum;
        PageVo<JournalDto> voDto = journalService.queryByKeyword(keyword, pageNum, pageSize);
        return voDto;
    }

    @GetMapping("/title/{title}")
    public ResponseBody<List<JournalDto>> queryListByTitle(@PathVariable("title") String title) {
        List<JournalDto> journalList = journalService.queryByTitle(title);
        return ResponseBody.success(journalList);
    }
    
    @GetMapping("/recent")
    public ResponseBody<List<JournalDto>> queryRecent(){
        List<JournalDto> journalList = journalService.queryRecent();
        return ResponseBody.success(journalList);
    }

}
