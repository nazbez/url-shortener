package com.nazbez.shortener.link;

import java.util.Optional;

public interface LinkRepository {
    Link save(Link link);
    Optional<Link> findByCode(String code);
    boolean deleteByCode(String code);
}
