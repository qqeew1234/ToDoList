package yun.table;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

    @Id
    private Long id;

    private String content;

    @ManyToOne
    private Post post;
}
