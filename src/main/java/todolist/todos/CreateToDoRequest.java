package todolist.todos;

import todolist.list.ToDoList;

public record CreateToDoRequest(String title, Long listId) {
}
