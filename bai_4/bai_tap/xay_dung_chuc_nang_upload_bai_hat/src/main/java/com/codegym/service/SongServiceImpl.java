package com.codegym.service;

import com.codegym.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SongServiceImpl implements ISongService {
    private List<Song> songs = new ArrayList<>();
    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void save(Song song) {
        songs.add(song);
    }

    @Override
    public Song findByName(String name) {
        return null;
//        return songs.get(.parseInt(name));
    }

    @Override
    public void update(String name, Song song) {
        for (Song song1 : songs) {
            if (song1.getName().equals( name)) {
                song1 = song;
                break;
            }
        }
    }

    @Override
    public void remove(String name) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getName().equals(name)) {
                songs.remove(i);
                break;
            }
        }
    }

}
