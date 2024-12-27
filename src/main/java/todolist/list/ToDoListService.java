package todolist.list;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListsService {

    public ListsService(ListsRepository listsRepository) {
        this.listsRepository = listsRepository;
    }

    private final ListsRepository listsRepository;



    public void create(CreateToDoListsRequest request){
        listsRepository.save(new ToDoList(request.title()));

    }

    public List<ListsResponse> findAll() {
        return listsRepository.findAll()
                .stream()
                .map(toDoList -> new ListsResponse(toDoList.getId(), toDoList.getTitle()))
                .toList();
    }


}
