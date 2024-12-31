package todolist.list;

import todolist.todos.ToDo;

import java.util.List;

public record ToDoListDetailResponse (
        Long listId,
        String title,
        List<ToDo>
        ){
        record ToDo(
                Long id,
                String content,
                boolean isCompleted
        ){}

}
