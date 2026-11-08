package com.nazbez.shortener.link;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/links")
public class LinkController {
    private static final String BASE_URL = "http://localhost:8081/";

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<LinkResponse> createLink(@RequestBody CreateLinkRequest request) {
        Link link = this.linkService.create(request.url());
        return ResponseEntity.created(URI.create("/api/links/" + link.code()))
                .body(toResponse(link));
    }

    @GetMapping("/{code}")
    public ResponseEntity<LinkResponse> getLink(@PathVariable String code) {
        return this.linkService.get(code)
                .map(link -> ResponseEntity.ok(toResponse(link)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteLink(@PathVariable String code) {
        return this.linkService.delete(code)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    private LinkResponse toResponse(Link link) {
        return new LinkResponse(link.code(), BASE_URL + link.code(), link.targetUrl());
    }
}
