package todolist.todos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
//findAllByToDoList(Long ToDoList)
}
