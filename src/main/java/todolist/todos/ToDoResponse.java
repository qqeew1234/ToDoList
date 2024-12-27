package todolist.todos;

public record ToDoResponse(
        Long id,
        String title,
        boolean complete
) {
}
