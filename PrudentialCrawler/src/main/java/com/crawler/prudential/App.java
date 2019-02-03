package com.crawler.prudential;

import com.crawler.prudential.webcrawler.Crawler;
import com.crawler.prudential.webcrawler.WebCrawler;
import com.crawler.prudential.webcrawler.input.InputParser;
import com.crawler.prudential.webcrawler.pojo.UserDataInput;
/**
 * Web crawler Main method where processing starts
 * arg[0]->site name to access 
 * arg[1]->file name to store data 
 * Ex http://www.prudential.co.uk/  mysitemaptest
 * @author saumitra
 *
 */
public class App {

    public static void main(String args[]){
        UserDataInput input = InputParser.parse(args);

        Crawler crawler = new WebCrawler(input);
        crawler.crawl();

        System.out.println("Web Crawler processing completed");
    }
}
