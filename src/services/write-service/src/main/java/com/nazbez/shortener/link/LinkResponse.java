package com.nazbez.shortener.link;

public record LinkResponse(String code, String shortUrl, String targetUrl) {
}
