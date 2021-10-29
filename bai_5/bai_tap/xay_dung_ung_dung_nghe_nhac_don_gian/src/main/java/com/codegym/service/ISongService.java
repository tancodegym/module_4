package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findOne(int id);
    void save(Song song);

    Song findByName(String name);

    Song update(Song song);

    void remove(int id);
}
