package com.codegym.service;

import com.codegym.model.Song;

import org.springframework.stereotype.Service;

import java.util.List;


public class SongServiceImpl implements ISongService {

    @Override
    public List<Song> findAll() {
//        String queryStr = "SELECT s FROM Song AS s";
//        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
//        return query.getResultList();
        return null;
    }

    @Override
    public Song findOne(int id) {
        return null;
    }

    @Override
    public void save(Song song) {
//        songs.add(song);

    }

    @Override
    public Song findByName(String name) {
        return null;
//        return songs.get(.parseInt(name));
    }

    @Override
    public Song update(Song song) {
        return null;
    }


    @Override
    public void remove(int id ){
//        for (int i = 0; i < songs.size(); i++) {
//            if (songs.get(i).getName().equals(name)) {
//                songs.remove(i);
//                break;
//            }
//        }
    }

}
