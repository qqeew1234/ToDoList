package todolist.list;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    private final ToDoListRepository toDoListRepository;


    public void create(CreateToDoListsRequest request) {
        toDoListRepository.save(new ToDoList(request.title()));

    }

    public List<ToDoListResponse> findAll() {
        return toDoListRepository.findAll()
                .stream()
                .map(toDoList -> new ToDoListResponse(toDoList.getId(), toDoList.getTitle()))
                .toList();
    }

    @Transactional
    public void update(Long listId, UpdateToDoListRequest request) {
        ToDoList toDoList = toDoListRepository.findById(listId)
                .orElseThrow(() -> new IllegalArgumentException("없는거임"));
        toDoList.setTitle(request.title());
        toDoListRepository.save(toDoList);
    }

//    //todo를 먼저 찾아서 todolist를 또 찾는ㅌ다?
//    @Transactional
//    public void updateList(Long toDoId, Long listId, UpdateToDoListRequest request) {
//        ToDo toDo = toDoListRepository.findById(toDoId)
//                .orElseThrow(() -> new IllegalArgumentException("없는todo"));
//        toDo.
//
//        ToDoList updateToDoList = toDoListRepository.findById()
//                .orElseThrow(() -> new IllegalArgumentException("없는todolist"));
//
//        toDo.setTitle(request.title());
//        toDoListRepository.save(toDoList);
//    }
}
