# -*- coding: utf-8 -*-
# scrapy crawl luoo
import scrapy
from bs4 import BeautifulSoup


class LuooCrawler(scrapy.Spider):
    name = 'luoo'
    htmlParser = 'html.parser'
    start_urls = ['http://www.luoo.net/music']

    def parse(self, response):
        res = BeautifulSoup(response.body, self.htmlParser)
        for page in res.select('.item'):
            item = page.select('.cover-wrapper')
            if item:
                url = item[0].get('href')
                yield scrapy.Request(url, self.parse_detail)

    def parse_detail(self, response):
        res = BeautifulSoup(response.body, self.htmlParser)
        self.log(res.prettify())
