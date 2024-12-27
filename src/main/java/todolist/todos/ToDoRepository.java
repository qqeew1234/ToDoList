package todolist.todos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
//findAllByToDoList(Long ToDoList)
}
