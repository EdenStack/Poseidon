# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class LuooItem(scrapy.Item):
    volTitle = scrapy.Field()
    volImg = scrapy.Field()
    volDesc = scrapy.Field()
    volKeywords = scrapy.Field()
    volTracks = scrapy.Field()
    volNumber = scrapy.Field()
    volDate = scrapy.Field()
