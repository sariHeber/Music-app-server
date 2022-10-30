package song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin
@RestController
@RequestMapping("songs")

public class SongController {
    @Autowired
    private SongService songsService;
    // Get all songs

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<SongModel> getAllSongs() {
        return songsService.getAll();
    }
    //getById

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Optional<SongModel> getSongById(@PathVariable String id) {
        return songsService.getById(id);
    }
    //gteByArtist

    @RequestMapping(value = "/byArtist/{artist}", method = RequestMethod.GET)
    public List<SongModel> getAllSongsByArtist(@PathVariable String artist) {
        return songsService.getByArtist(artist);
    }
    //edit

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public void EditSong(@RequestBody SongModel newSong, @PathVariable String id) {
        songsService.EditSong(newSong, id);
    }
    //addSong

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public SongModel addSong(@RequestBody SongModel newSong) {
        return songsService.add(newSong);
    }
    //delete song

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean deleteSongById(@PathVariable String id) {
        return songsService.delete(id);
    }

}
