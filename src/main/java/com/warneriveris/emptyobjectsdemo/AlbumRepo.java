package com.warneriveris.emptyobjectsdemo;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface AlbumRepo extends CrudRepository<Album, Long> {
    Optional<Album> findByTitle(String title);
}
