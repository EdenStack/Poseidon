package com.tneciv.poseidon.controller;

import com.tneciv.poseidon.common.ResponseWrapper;
import com.tneciv.poseidon.service.TrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Future;

/**
 * Created by Tneciv on 2017/3/30.
 */
@Controller
@Slf4j
public class IndexController {

    @RequestMapping("/")
    public String redirectToIndex() {
        return "index";
    }

    @Autowired
    TrackService trackService;

    @GetMapping("/testAsync")
    @ResponseBody
    public ResponseWrapper get() throws Exception {
        long startMill = System.currentTimeMillis();
        long id = Thread.currentThread().getId();
        Future<String> future1 = trackService.getSth(1000, "future1");
        Future<String> future2 = trackService.getSth(2000, "future2");
        Future<String> future3 = trackService.getSth(3000, "future3");
        Future<String> future4 = trackService.getSth(500, "future4");
        Future<String> future5 = trackService.getSth(1000, "future5");
        String result = String.format("f1 : %s , f2 : %s , f3 : %s ", future1.get(), future2.get(), future3.get());
        long endMill = System.currentTimeMillis();
        long costTime = endMill - startMill;
        log.info("耗时： {} ms , 主线程 ID : {} , 结果 : {}", costTime, id, result);
        return ResponseWrapper.success(costTime);
    }

}
