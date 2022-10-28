package com.mantra.backendside.wallpapers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Wallpapers {
    @Id
    @GeneratedValue
    private long id;
    private String filename;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Wallpaper{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                '}';
    }


}
