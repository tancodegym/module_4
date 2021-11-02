package codegym.service;

import codegym.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SongService  implements ISongService{
    static List<Song> songList   = new ArrayList<>();
    static{
        songList.add(new Song("Bai Hat 1","Ca si 1","Nhac Tre"));
        songList.add(new Song("Bai Hat 2","Ca si 2","Nhac Gia"));
        songList.add(new Song("Bai Hat 3","Ca si 3","Nhac Nguoi Lon"));
        songList.add(new Song("Bai Hat 4","Ca si 4","Nhac Con nit"));
    }
    @Override
    public void addSong(Song song) {
        songList.add(song);
    }

    @Override
    public List<Song> findListSong() {
        return songList;
    }

    @Override
    public Song findByName(String name) {
        for(Song song: songList){
            if(song.getName().equals(name)){
                return song;
            }
        }
        return null;
    }


}
