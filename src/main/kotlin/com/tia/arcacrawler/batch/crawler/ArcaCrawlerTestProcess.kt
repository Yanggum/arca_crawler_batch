package com.tia.arcacrawler.batch.crawler

import com.tia.arcacrawler.batch.domain.entity.ArcaCrawlerTest
import org.jsoup.Jsoup

class ArcaCrawlerTestProcess {
    private val crawler = this;

    fun getInstance(): ArcaCrawlerTestProcess {
        return crawler;
    }

    fun crawl() : MutableList<ArcaCrawlerTest> {
        val test = Jsoup.connect("https://arca.live").get()
        val regex = Regex("[0-9][0-9]-[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9] q ");
        val regex2 = Regex(" \\[[0-9]+\\]$");
        val list = test.body().getElementsByAttributeValueContaining("href", "/b/live");
        val resultList = mutableListOf<ArcaCrawlerTest>();

        for (element in list) {
            val temp = element
                .text()
                .replace(regex, "")
                .replace(regex2, "");
            print(temp);
            var resultItem = ArcaCrawlerTest();
            resultItem.itemContent = temp;
            resultList.add(resultItem);
        }

        return resultList;
    }
}