package yun.table;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Board {

    public Board( String name) {
        this.name = name;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    private String name;

    @OneToMany(mappedBy = "board")
    private List<Post> posts;
}
