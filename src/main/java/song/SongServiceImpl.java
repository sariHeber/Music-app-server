package song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService{
    @Autowired
    private  SongRepo repository;

    @Override
    //get all songs
    public List<SongModel> getAll() {
        return repository.findAll();
    }
    @Override
    //getById
    public Optional<SongModel> getById(String id){
        return (Optional<SongModel>)(repository.findById(id));
    }
    @Override
    //get by artist
    public List<SongModel> getByArtist(String artist) {
        return repository.findByArtist(artist);
    }
    @Override
    //edit song
    public void EditSong(SongModel song, String id) {
        repository.findById(id).map(s -> {
                 s.setArtist(song.getArtist());
                 s.setGenre(song.getGenre());
                 s.setLength(song.getLength());
                 s.setPrice(song.getPrice());
                 s.setTitle(song.getTitle());
                 return repository.save(s);
             }
     ).orElseGet(()->{
         song.setId(id);
         return repository.save(song);
        });
    }
    @Override
    //delete song
    public boolean delete(String id){
        repository.deleteById(id);
        return true;
    }

    @Override
    //add song
    public SongModel add(SongModel song) {
        repository.save(song);
        return song;
    }


}
