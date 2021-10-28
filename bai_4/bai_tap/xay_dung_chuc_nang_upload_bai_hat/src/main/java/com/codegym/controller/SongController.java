package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.ISongService;
import com.codegym.service.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;

    private final ISongService iSongService = new SongServiceImpl();
    static  List<String> kindList = new ArrayList<>();
    static{

        kindList.add("Nhạc Trẻ");
        kindList.add("Nhạc Rock");
        kindList.add("Nhạc EDM");
        kindList.add("Nhạc Không lời");
    }
    @GetMapping("")
    public String index(Model model) {
        List<Song> songList = iSongService.findAll();
        model.addAttribute("songList", songList);
        for(Song song: songList){
            System.out.println(song.getKindOfMusics());
        }
        model.addAttribute("kindList", kindList);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", new SongForm());
        modelAndView.addObject("kindList", kindList);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        String[] array = fileName.split("\\.");
        ModelAndView modelAndView = new ModelAndView("/index");
        boolean checkFile = array[1].equals("mp3")||array[1].equals("wav")||array[1].equals("ogg")||array[1].equals("m4p");
        if (checkFile) {
            try {
                FileCopyUtils.copy(songForm.getSong().getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Song song = new Song(songForm.getName(), songForm.getSingger(), songForm.getKindOfMusics(), songForm.getPath());
            iSongService.save(song);

            List<Song> songList = iSongService.findAll();
            modelAndView.addObject("songList", songList);
            modelAndView.addObject("message", "Created new song successfully !");
        } else {
            modelAndView.addObject("message", "Created new song error !");
        }
        return modelAndView;
    }
}
