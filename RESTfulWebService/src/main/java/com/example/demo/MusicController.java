package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MusicController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/music")
    public Music getMusic(@RequestParam(value = "title", defaultValue = "Good for you") String title,
                          @RequestParam(value = "artist", defaultValue = "Selena Gomez") String artist) {
        return new Music(counter.incrementAndGet(), title, artist);
    }

    @GetMapping("/musics")
    public List<Music> getMusicList() {
        return List.of(
                new Music(1, "Good for you", "Selena Gomez"),
                new Music(2, "I was never there", "The Weeknd"),
                new Music(3, "New York", "AR Rahman")
        );
    }
}
