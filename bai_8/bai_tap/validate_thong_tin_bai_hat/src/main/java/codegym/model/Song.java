package codegym.model;

import org.hibernate.annotations.Table;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Song {
    @NotEmpty
    @Size(max = 800)
    @Pattern(regexp = "[A-z0-9]*", message = "Name cannot be blank, must be less than 800 characters and contain no special characters !")
    private String name;
    @NotEmpty
    @Size(max = 300)
    @Pattern(regexp = "[A-z0-9]*", message = "Singger Name cannot be blank, must be less than 300 characters and contain no special characters !")
    private String singger;
    @NotEmpty
    @Size(max = 1000)
    @Pattern(regexp = "[A-z0-9,]*", message = "Type cannot be blank, must be less than 1000 characters and contain no special characters except commas !")
    private String typeOfSong;

    public Song() {
    }

    public Song(@NotEmpty @Size(max = 800) @Pattern(regexp = "[A-z0-9]*", message = "Name cannot be blank, must be less than 800 characters and contain no special characters !") String name, @NotEmpty @Size(max = 300) @Pattern(regexp = "[A-z0-9]*", message = "Singger Name cannot be blank, must be less than 300 characters and contain no special characters !") String singger, @NotEmpty @Size(max = 1000) @Pattern(regexp = "[A-z0-9,]*", message = "Type cannot be blank, must be less than 1000 characters and contain no special characters except commas !") String typeOfSong) {
        this.name = name;
        this.singger = singger;
        this.typeOfSong = typeOfSong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingger() {
        return singger;
    }

    public void setSingger(String singger) {
        this.singger = singger;
    }

    public String getTypeOfSong() {
        return typeOfSong;
    }

    public void setTypeOfSong(String typeOfSong) {
        this.typeOfSong = typeOfSong;
    }
}
