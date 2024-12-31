package todolist.todos;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import todolist.list.ToDoList;
import todolist.list.ToDoListRepository;
import todolist.list.UpdateToDoListRequest;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final ToDoListRepository toDoListRepository;

    public ToDoService(ToDoRepository toDoRepository, ToDoListRepository toDoListRepository) {
        this.toDoRepository = toDoRepository;
        this.toDoListRepository = toDoListRepository;
    }

    public void create(CreateToDoRequest request){
        ToDoList toDoList = toDoListRepository.findById(request.listId()).orElseThrow();
        toDoRepository.save(new ToDo(request.title(), toDoList));
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

//    public void update(long id, CreateToDoRequest updateToDo) {
//        ToDo toDo = toDoRepository.findById(id).orElseThrow();
//        ToDoList toDoList = toDoListRepository.findById(id).orElseThrow();
//        toDo.update(updateToDo);
//        toDoRepository.save(toDo);
//    }
    @Transactional
    public void update(Long id, UpdateToDoRequest request){
        ToDoList toDoList = toDoListRepository.findById(request.listId())
                .orElseThrow();
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow();
        toDo.changeTitleAndList(request.title(), toDoList);
    }

    public void flip(long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow();
        toDo.flip();
    }

    public List<ToDoResponse> findAllByCompleted(Boolean isCompleted) {
        if (isCompleted == null){
            return toDoRepository.findAll()
                    .stream()
                    .map(toDo -> new ToDoResponse(
                            toDo.getId(),
                            toDo.getTitle(),
                            toDo.isComplete()
                    )).toList();
        }
        return toDoRepository.findByIsCompleted(isCompleted)
                .stream()
                .map(toDo -> new ToDoResponse(
                        toDo.getId(),
                        toDo.getTitle(),
                        toDo.isComplete()
                )).toList();
    }

//    public void complete(long todoId) {
//        Optional<ToDoList> optionalToDoList = toDoListRepository.findById(todoId);
//        if (optionalToDoList.isPresent()){
//            ToDoList toDoList = optionalToDoList.get();
//            toDoList.setDone(!todo.is)
//        }
//    }
}
