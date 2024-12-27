package todolist.todos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoListController {

    private ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping("/todos")
    void createToDoList(@RequestBody CreateToDoListRequest request){
        toDoListService.create(request);
    }

    @GetMapping("/todos")
    public List<ToDoListResponse> findAll(){
        return toDoListService.findAll();

    }

    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable long id){
        toDoListService.delete(id);
    }


    @PutMapping ("/todos/{id}")
    public void update(@PathVariable long id, @RequestBody CreateToDoListRequest updatetodo){
        toDoListService.update(id, updatetodo);
    }

    @PatchMapping("/todos/{id}")
    void flip (@PathVariable long id){
        toDoListService.flip(id);
    }

}
