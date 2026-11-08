package com.nazbez.shortener.link;

import java.time.Instant;

public record Link(String code, String targetUrl, Instant createdAt) {

}
