package yun.table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Board {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "board")
    private List<Post> posts;
}
