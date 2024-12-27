package todolist.list;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListsController {

    private final ListsService listsService;


    public ListsController(ListsService listsService) {
        this.listsService = listsService;
    }

    @PostMapping("/lists")
    void create(CreateListsRequest request){
        listsService.create(request);
    }

    @GetMapping("/lists")
    List<ListsResponse> read(){
        return listsService.findAll();
    }
}
