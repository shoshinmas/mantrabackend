package com.mantra.backendside.wallpapers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WallpaperRepository extends JpaRepository<Wallpapers, Integer> {

    public List<Wallpapers> findByFilename(String filename);
}
