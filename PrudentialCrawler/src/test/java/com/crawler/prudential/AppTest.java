package com.crawler.prudential;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;

import com.crawler.prudential.App;
import com.crawler.prudential.webcrawler.WebCrawler;

import org.junit.After;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

//    @Test
//    public void testApp() {
//        File tmp = new File("./prudential.map");
//        tmp.deleteOnExit();
//        String[] args = {"http://www.prudential.co.uk", tmp.getPath()};
//        WebCrawler mock = Mockito.mock(WebCrawler.class);
//
//        App.main(args);
//        verify(mock, atMost(1)).crawl();
//
//        assertTrue(outContent.toString().contains("Crawled http://www.prudential.co.uk in "));
//    }

    @Test(expected = IllegalArgumentException.class)
    public void testApp_invalidUrl() {
        String[] args = {"some invalid url", "mytestsite.map"};
        App.main(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApp_NullUrl() {
        String[] args = {null, "mytestsite.map"};
        App.main(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApp_NulFilename() {
        String[] args = {"https://www.prudential.co.uk", null};
        App.main(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApp_EmptyFilename() {
        String[] args = {null, ""};
        App.main(args);
    }
}
