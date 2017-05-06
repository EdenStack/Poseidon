# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class TrackItem(scrapy.Item):
    trackName = scrapy.Field()
    trackImg = scrapy.Field()
    trackMP3Url = scrapy.Field()
    trackArtist = scrapy.Field()
    trackAlbum = scrapy.Field()
