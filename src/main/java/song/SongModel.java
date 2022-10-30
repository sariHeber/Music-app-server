package song;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Document(collection = "songs")
public class SongModel {
    private @Id String id;
    private String title;
    private String artist;
    private Genre genre;
    private int length;
    private float price;
}
