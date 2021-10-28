package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findByName(String name);

    void update(String name, Song song);

    void remove(String name);
}
