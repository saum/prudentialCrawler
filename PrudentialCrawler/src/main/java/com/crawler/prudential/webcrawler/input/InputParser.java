package com.crawler.prudential.webcrawler.input;

import com.crawler.prudential.webcrawler.pojo.UserDataInput;
import com.google.common.base.Strings;

import java.net.MalformedURLException;
import java.net.URL;

public class InputParser {

    public static UserDataInput parse(String[] args) {
        UserDataInput input = new UserDataInput();
        if (args == null || args.length < 2) {
            throw new IllegalArgumentException("Expects a domain and a filename to create");
        }

        String domain = args[0];
        if (Strings.isNullOrEmpty(domain)) {
            throw new IllegalArgumentException("Expects a valid domain");
        }
        try {
            URL site = new URL(domain);
            input.setDomainToCrawl(site);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Expects a valid URL");
        }

        String sitemapFile = args[1];
        if (Strings.isNullOrEmpty(sitemapFile)) {
            throw new IllegalArgumentException("Expects a valid filename");
        }
        input.setSitemapPath(sitemapFile);

        return input;
    }
}
