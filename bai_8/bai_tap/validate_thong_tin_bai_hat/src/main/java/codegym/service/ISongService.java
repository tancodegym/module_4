package codegym.service;

import codegym.model.Song;

import java.util.List;

public interface ISongService {
    void addSong(Song song);
    List<Song> findListSong();
    Song findByName(String name);
}
