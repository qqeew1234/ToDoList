package todolist.todos;

public record UpdateToDoRequest(
        String title,
        Long listId
) {
}
