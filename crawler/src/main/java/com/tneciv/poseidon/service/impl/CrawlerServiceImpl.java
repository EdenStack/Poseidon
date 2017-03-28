package com.tneciv.poseidon.service.impl;

import com.tneciv.poseidon.dao.JournalMapper;
import com.tneciv.poseidon.dao.TrackMapper;
import com.tneciv.poseidon.entity.Journal;
import com.tneciv.poseidon.entity.Track;
import com.tneciv.poseidon.retrofit.ApiServiceFactory;
import com.tneciv.poseidon.retrofit.LuooService;
import com.tneciv.poseidon.service.CrawlerService;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import static com.tneciv.poseidon.common.CommonUtil.*;

/**
 * Created by Tneciv on 2017/3/25.
 */
@Service
public class CrawlerServiceImpl implements CrawlerService {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerServiceImpl.class);

    @Autowired
    private JournalMapper journalMapper;
    @Autowired
    private TrackMapper trackMapper;

    @Override
    public void handle(int id) throws Exception {

        LuooService service = ApiServiceFactory.getInstance().create(LuooService.class);
        service.getJournalById(id)
                .subscribe(s -> handleResponseHtml(s));

    }

    private void handleResponseHtml(String response) {
        Document document = Jsoup.parse(response);
        String keywords = document.select("meta[name=keywords]").attr("content");
        String desc = document.select("div.vol-desc").text();
        String volCoverImage = document.select("img.vol-cover").attr("src");
        String volDate = document.select("span.vol-date").text();
        String title = document.select("span.vol-title").text();
        String journalId = document.select("span.vol-number").text();
        Elements relativeVols = document.getElementsByClass("relative-vol").select("div.item");
        List<String> list = new ArrayList<>();
        relativeVols.forEach(element -> {
            String vol = element.select("a.cover-wrapper").attr("href");
            String id = StringUtils.substringAfter(vol, "http://www.luoo.net/music/");
            list.add(id);
        });

        List<String> trackIds = new ArrayList<>();
        List<Track> trackList = new ArrayList<>();
        Elements tracks = document.select("div.vol-tracklist")
                .select("li.track-item");
        tracks.forEach(new Consumer<Element>() {
            @Override
            public void accept(Element element) {
                String sortId = element.select("a.trackname").text().substring(0, 2);
                String id = element.select("li.track-item").attr("id");
                String trackId = substringTrackId(id);
                String trackCoverImg = element.select("img.cover").attr("src");
                String name = element.select("p.name").text();
                String artist = element.select("p.artist").text();

                String album = element.select("p.album").text();
                trackIds.add(trackId);

                Track track = new Track();
                track.setAlbum(substringAlbum(album));
                track.setArtist(substringArtist(artist));
                track.setCoverImg(substringImgUrl(trackCoverImg));
                track.setCreateTime(new Date());
                track.setTrackId(Integer.valueOf(trackId));
                track.setName(name);
                track.setMp3Url(spliceMP3Url(journalId, sortId));
                trackMapper.insert(track);
                trackList.add(track);

            }
        });

        Journal journal = new Journal();
        journal.setKeyWords(keywords);
        journal.setVolCoverImg(substringImgUrl(volCoverImage));
        journal.setVolDesc(desc);
        journal.setTitle(title);
        journal.setVolDate(volDate);
        journal.setCreateTime(new Date());
        journal.setRelativeVols(convertListToStringArr(list));
        journal.setTracks(convertListToStringArr(trackIds));
        journal.setJournalId(Integer.valueOf(journalId));

        journalMapper.insert(journal);
    }

}
