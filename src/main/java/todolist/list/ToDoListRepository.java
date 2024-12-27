package todolist.list;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ListsRepository extends JpaRepository<ToDoList, Long> {
}
