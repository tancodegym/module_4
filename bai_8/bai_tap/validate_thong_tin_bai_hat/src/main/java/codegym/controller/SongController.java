package codegym.controller;

import codegym.model.Song;
import codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SongController {
    @Autowired
    ISongService iSongService;

    @GetMapping("")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("newSong", new Song());
        modelAndView.addObject("songList",iSongService.findListSong());
        return modelAndView;
    }
    @PostMapping("/validateSong")
    public ModelAndView checkValidation(@Validated @ModelAttribute("newSong") Song song, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/index");
        }
        ModelAndView modelAndView = new ModelAndView("/index");
        iSongService.addSong(song);
        modelAndView.addObject("message","New Song Create Successfully !");
        modelAndView.addObject("songList",iSongService.findListSong());
        return modelAndView ;
    }
    @GetMapping("/edit/{name}")
    public ModelAndView showEditForm(@PathVariable String name){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("editSong", iSongService.findByName(name));
        return modelAndView;

    }
    @PostMapping("/validateedit")
    public ModelAndView check(@Validated @ModelAttribute("editSong") Song song, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/edit");
        }
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("message","Edit Song  Successfully !");
        modelAndView.addObject("songList",iSongService.findListSong());
        return modelAndView ;
    }
}
