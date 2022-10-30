package song;

import java.util.List;
import java.util.Optional;


public interface SongService {
  List<SongModel> getAll();
  Optional<SongModel> getById(String id);
  boolean delete(String id);
  List<SongModel> getByArtist(String artist);
  void EditSong(SongModel song,String id);
  SongModel add(SongModel song);

}
