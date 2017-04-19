# -*- coding: utf-8 -*-
import scrapy


class LuooSpider(scrapy.Spider):
    name = "luoo"

    allowed_domains = ["luoo.net"]
    start_urls = [
        "http://www.luoo.net/vol/index/1012"
    ]

    def parse(self, response):
        filename = "music-" + response.url.split("/")[-1]
        with open(filename, 'wb') as f:
            f.write(response.body)
        for sel in response.xpath('//ul/li'):
            title = sel.xpath('a/text()').extract()
            link = sel.xpath('a/@href').extract()
            desc = sel.xpath('text()').extract()
            print(title, link, desc)
