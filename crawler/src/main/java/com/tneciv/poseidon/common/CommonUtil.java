package com.tneciv.poseidon.common;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Tneciv on 2017/3/25.
 */
public class CommonUtil {

    public static final String JPG_SEPARATOR = ".jpg";

    public static String convertListToStringArr(List<String> list) {
        return String.join(",", list);
    }

    public static List<String> convertStringArrToList(String arr) {
        String[] strings = StringUtils.split(arr, ",");
        List<String> list = Arrays.asList(strings);
        return list;
    }

    public static String substringImgUrl(String url) {
        return StringUtils.substringBefore(url, JPG_SEPARATOR) + JPG_SEPARATOR;
    }

    public static String substringArtist(String artist) {
        return StringUtils.substringAfter(artist, "Artist:").trim();
    }

    public static String substringAlbum(String album) {
        return StringUtils.substringAfter(album, "Album:").trim();
    }

    public static String substringTrackId(String trackId) {
        return StringUtils.substringAfter(trackId, "track");
    }

    public static String spliceMP3Url(String journalId, String sortId) {
        String s = "http://mp3-cdn.luoo.net/low/luoo/radio863/06.mp3";
        String url = new StringBuilder("http://mp3-cdn.luoo.net/low/luoo/radio")
                .append(journalId)
                .append("/")
                .append(sortId)
                .append(".mp3").toString();
        return url;
    }

    public static String spliceLikeSQL(String s) {
        return "%" + s + "%";
    }
}
