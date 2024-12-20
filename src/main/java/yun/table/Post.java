package yun.table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Post {

    @Id
    private  Long id;

    private String title;
    private String content;

    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

}
