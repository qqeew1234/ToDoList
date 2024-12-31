package todolist.todos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping("/todos")
    void createToDoList(@RequestBody CreateToDoRequest request){
        toDoService.create(request);
    }


    //여러개의할일조회
    @GetMapping("/todos")
    public List<ToDoResponse> findAll(@RequestParam(required = false)Boolean isCompleted){
        return toDoService.findAllByCompleted(isCompleted);
        // return toDoService.findAll();
    }

    @DeleteMapping("/todos/{todoId}")
    public void delete(@PathVariable long id){
        toDoService.delete(id);
    }


    @PutMapping ("/todos/{todoId}")
    public void update(@PathVariable long id, @RequestBody CreateToDoRequest updatetodo){
        toDoService.update(id, updatetodo);
    }

    @PatchMapping("/todos/{todoId}")
    void flip (@PathVariable long id){
        toDoService.flip(id);
    }


}
