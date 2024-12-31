package todolist.list;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoListController {

    private final ToDoListService toDoListService;


    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping("/lists")
    void create(CreateToDoListsRequest request){
        toDoListService.create(request);
    }

    @GetMapping("/lists")
    List<ToDoListResponse> read(){
        return toDoListService.findAll();
    }

    @PatchMapping("/lists/{todoid}")
    public void update(@PathVariable Long listId, @RequestBody UpdateToDoListRequest request){
        toDoListService.update(listId, request);
    }

    @PostMapping("/lists/{todoid}")
    public void updatelist(@PathVariable Long toDoId, Long listId,@RequestBody UpdateToDoListRequest request){
//        toDoListService.updateList(toDoId, listId, request);
    }

    @GetMapping("/lists/{listId}")
    ToDoListDetailResponse findById (@PathVariable Long listId){
        return this.toDoListService.findById;


    }
    @DeleteMapping("lists/{listID}")
    public void deleteById(@PathVariable Long listId){
        toDoListService.deleteById(listID);
    }
}
