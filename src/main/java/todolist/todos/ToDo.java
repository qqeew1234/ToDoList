package todolist.todos;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean complete;
    private boolean isCompleted = false;

    public boolean isComplete() {
        return complete;
    }

    private String title;

    public ToDoList() {
    }

    public ToDoList(String titleValue){
        title = titleValue;
    }


    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

//    private String description;

    public void update(CreateToDoListRequest updatetodo) {
        title = updatetodo.title();
    }

    public void flip() {
        this.isCompleted = !this.isCompleted;
    }
}


