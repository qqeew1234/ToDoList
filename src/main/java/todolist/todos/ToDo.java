package todolist.todos;


import jakarta.persistence.*;
import todolist.list.ToDoList;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private boolean isCompleted = false;

    public boolean isComplete() {
        return isCompleted;
    }

    private String title;

    @ManyToOne
    private ToDoList toDoList;

    public ToDo() {
    }

    public ToDo(String titleValue){
        title = titleValue;
    }


    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

//    private String description;

    public void update(CreateToDoRequest updatetodo) {
        title = updatetodo.title();
    }

    public void flip() {
        this.isCompleted = !this.isCompleted;
    }
}


