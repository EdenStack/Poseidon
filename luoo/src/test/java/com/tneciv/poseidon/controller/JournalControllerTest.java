package com.tneciv.poseidon.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by Tneciv on 2017/5/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JournalControllerTest {

    /**
     * @see com.tneciv.poseidon.config.DruidConfig
     * should be exclued when run this test case
     */
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void queryByIdTest() throws Exception {
        String resultJson = "{\n" +
                "  \"succ\": true,\n" +
                "  \"msg\": \"操作成功\",\n" +
                "  \"content\": {\n" +
                "    \"tracks\": [\n" +
                "      {\n" +
                "        \"trackId\": 2461,\n" +
                "        \"artist\": \"Greenfield & Cook\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2189/cover.jpg\",\n" +
                "        \"album\": \"Greenfield & Cook\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/01.mp3\",\n" +
                "        \"trackName\": \"It’s Up To You, Part 1\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2462,\n" +
                "        \"artist\": \"Marian Henderson\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2190/cover.jpg\",\n" +
                "        \"album\": \"The Restless Years\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/02.mp3\",\n" +
                "        \"trackName\": \"The Streets of Forbes\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2463,\n" +
                "        \"artist\": \"Tamarack\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2191/cover.jpg\",\n" +
                "        \"album\": \"On The Grand\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/03.mp3\",\n" +
                "        \"trackName\": \"Pawpine\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2464,\n" +
                "        \"artist\": \"Lionel Long\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2192/cover.jpg\",\n" +
                "        \"album\": \"Songs Of The Sea\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/04.mp3\",\n" +
                "        \"trackName\": \"Golden Vanity\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2465,\n" +
                "        \"artist\": \"Emma Junaro\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2193/cover.jpg\",\n" +
                "        \"album\": \"Resolana\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/05.mp3\",\n" +
                "        \"trackName\": \"Romance Para Mi Niño\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2466,\n" +
                "        \"artist\": \"Michel Polnareff\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2194/cover.jpg\",\n" +
                "        \"album\": \"Polnareff’s\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/06.mp3\",\n" +
                "        \"trackName\": \"Qui a Tué Grand’ Maman?\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2467,\n" +
                "        \"artist\": \"Stavros\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2195/cover.jpg\",\n" +
                "        \"album\": \"VA swirling echoes\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/07.mp3\",\n" +
                "        \"trackName\": \"Pou Pas(Where are you going)\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2468,\n" +
                "        \"artist\": \"David Soul\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2196/cover.jpg\",\n" +
                "        \"album\": \"Los Mejores Dias De Mi Vida\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/08.mp3\",\n" +
                "        \"trackName\": \"The Dutchman\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2469,\n" +
                "        \"artist\": \"Clay Toyani/David Snell/Jeff C\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2197/cover.jpg\",\n" +
                "        \"album\": \"Henry the Human Fly\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/09.mp3\",\n" +
                "        \"trackName\": \"Nobody’s Wedding\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2470,\n" +
                "        \"artist\": \"Richard Thompson\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2198/cover.jpg\",\n" +
                "        \"album\": \"Double Back\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/10.mp3\",\n" +
                "        \"trackName\": \"The Ferryman\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2471,\n" +
                "        \"artist\": \"Tom Paxton & Anne Hills\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2199/cover.jpg\",\n" +
                "        \"album\": \"Chicago Live\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/11.mp3\",\n" +
                "        \"trackName\": \"Whose Garden Was This\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2472,\n" +
                "        \"artist\": \"Mike Harding\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2200/cover.jpg\",\n" +
                "        \"album\": \"Bombers’ Moon\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/12.mp3\",\n" +
                "        \"trackName\": \"The Band Played Waltzing Matilda\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"trackId\": 2473,\n" +
                "        \"artist\": \"Eric Andersen\",\n" +
                "        \"coverImg\": \"http://img-cdn.luoo.net/pics/albums/2201/cover.jpg\",\n" +
                "        \"album\": \"Today Is the Highway\",\n" +
                "        \"mp3Url\": \"http://mp3-cdn.luoo.net/low/luoo/radio222/13.mp3\",\n" +
                "        \"trackName\": \"Looking Glass\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"id\": 223,\n" +
                "    \"title\": \"不歇的年代\",\n" +
                "    \"journalId\": 222,\n" +
                "    \"keyWords\": \"不歇的年代,民谣,Folk\",\n" +
                "    \"volCoverImg\": \"http://img-cdn.luoo.net/pics/vol/525519d9271e5.jpg\",\n" +
                "    \"relativeVols\": \"263,665,431,830\",\n" +
                "    \"volDate\": \"2010-10-30\",\n" +
                "    \"volDesc\": \"\"\n" +
                "  },\n" +
                "  \"options\": {}\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.get("/journal/222"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resultJson));

    }

}