package todolist.list;

public record ToDoListResponse(
        Long listId,
        String title,
        int numOfToDo

) {

}
