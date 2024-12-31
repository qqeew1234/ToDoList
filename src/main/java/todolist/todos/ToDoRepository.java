package todolist.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import todolist.list.ToDoList;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
//findAllByToDoList(Long ToDoList)


    //jpa
    List<ToDo> findByIsCompleted(boolean isCompleted);

    int countByToDoList(ToDoList toDoList);
}
