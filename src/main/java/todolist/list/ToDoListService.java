package todolist.list;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import todolist.todos.ToDoRepository;

import java.util.List;

@Service
public class ToDoListService {


    private final ToDoListRepository toDoListRepository;
    private final ToDoRepository toDoRepository;

    public ToDoListService(ToDoListRepository toDoListRepository, ToDoRepository toDoRepository) {
        this.toDoListRepository = toDoListRepository;
        this.toDoRepository = toDoRepository;
    }

//    public ToDoListService(ToDoListRepository toDoListRepository) {
//        this.toDoListRepository = toDoListRepository;
//    }

    public ToDoListDetailResponse findById(Long listId){
        ToDoList toDoList = toDoListRepository.findById(listId)
                .orElseThrow();
        List<Todo> todo = ToDoRepository.findByToDoList(toDoList)
    }


    public void create(CreateToDoListsRequest request) {
        toDoListRepository.save(new ToDoList(request.title()));
    }

    public List <ToDoListResponse> findAll(){
        return toDoListRepository.findAll()
                .stream()
                .map(list-> new ToDoListResponse(
                        list.getId(),
                        list.getTitle(),
                        toDoRepository.countByToDoList(list)
                ) ).toList();
    }

//    public List<ToDoListResponse> findAll() {
//        return toDoListRepository.findAll()
//                .stream()
//                .map(toDoList -> new ToDoListResponse(
//                        toDoList.getId(),
//                        toDoList.getTitle(),
//                        toDoRepository.countByToDoList(list)))
//                .toList();
//    }

    @Transactional
    public void update(Long listId, UpdateToDoListRequest request) {
        ToDoList toDoList = toDoListRepository.findById(listId)
                .orElseThrow(() -> new IllegalArgumentException("없는거임"));
        toDoList.setTitle(request.title());
        toDoListRepository.save(toDoList);
    }

    public void detailList(Long listId){

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
