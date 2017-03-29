package com.tneciv.poseidon.controller;

import com.tneciv.poseidon.entity.Journal;
import com.tneciv.poseidon.service.JournalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;

/**
 * Created by Tneciv on 2017/3/29.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(JournalController.class)
public class JournalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JournalService journalService;

    @Test
    public void queryById() throws Exception {
        Journal journal = new Journal(222, "sdsd", 222, "sdd", "sdsd", "", "", "", new Date(), "");
        List<Journal> list = new ArrayList<>();
        list.add(journal);
        given(this.journalService.queryByJournalId(222))
                .willReturn(list);

    }

}