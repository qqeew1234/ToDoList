package todolist.todos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public void create(CreateToDoRequest request){
        toDoRepository.save(new ToDo(request.title()));
    }

    public List<ToDoResponse> findAll() {
        List<ToDo> toDos = toDoRepository.findAll();
        return toDos.stream()
                .map(toDo -> new ToDoResponse(
                        toDo.getId(),
                        toDo.getTitle(),
                        toDo.isComplete()
                ))
                .toList();
    }

    public void delete(long id) {
        toDoRepository.deleteById(id);
    }

    public void update(long id, CreateToDoRequest updatetodo) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow();
        toDo.update(updatetodo);
        toDoRepository.save(toDo);
    }

    public void flip(long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow();
        toDo.flip();
    }

//    public void complete(long todoId) {
//        Optional<ToDoList> optionalToDoList = toDoListRepository.findById(todoId);
//        if (optionalToDoList.isPresent()){
//            ToDoList toDoList = optionalToDoList.get();
//            toDoList.setDone(!todo.is)
//        }
//    }
}
