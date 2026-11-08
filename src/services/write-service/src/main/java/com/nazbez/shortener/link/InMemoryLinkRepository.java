package com.nazbez.shortener.link;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryLinkRepository implements LinkRepository {
    private final ConcurrentHashMap<String, Link> storage = new ConcurrentHashMap<>();

    @Override
    public Link save(Link link) {
        this.storage.put(link.code(), link);
        return link;
    }

    @Override
    public Optional<Link> findByCode(String code) {
        return Optional.ofNullable(this.storage.get(code));
    }

    @Override
    public boolean deleteByCode(String code) {
        return this.storage.remove(code) != null;
    }
}
