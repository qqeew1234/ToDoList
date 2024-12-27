package todolist.todos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {

    ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public void create(CreateToDoListRequest request){
        toDoListRepository.save(new ToDoList(request.title()));
    }

    public List<ToDoListResponse> findAll() {
        List<ToDoList> toDoLists = toDoListRepository.findAll();
        return toDoLists.stream()
                .map(toDoList -> new ToDoListResponse(
                        toDoList.getId(),
                        toDoList.getTitle(),
                        toDoList.isComplete()
                ))
                .toList();
    }

    public void delete(long id) {
        toDoListRepository.deleteById(id);
    }

    public void update(long id, CreateToDoListRequest updatetodo) {
        ToDoList toDoList = toDoListRepository.findById(id).orElseThrow();
        toDoList.update(updatetodo);
        toDoListRepository.save(toDoList);
    }

    public void flip(long id) {
        ToDoList toDoList = toDoListRepository.findById(id).orElseThrow();
        toDoList.flip();
    }

//    public void complete(long id) {
//        Optional<ToDoList> optionalToDoList = toDoListRepository.findById(id);
//        if (optionalToDoList.isPresent()){
//            ToDoList toDoList = optionalToDoList.get();
//            toDoList.setDone(!todo.is)
//        }
//    }
}
