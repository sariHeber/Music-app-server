package song;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SongRepo extends MongoRepository<SongModel, String> {
    public List<SongModel> findByArtist(String artist);
}
