package todolist.todos;

public record ToDoListResponse(
        Long id,
        String title,
        boolean complete
) {
}
