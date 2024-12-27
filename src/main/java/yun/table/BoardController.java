package yun.table;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }



    @PostMapping("/boards")
    void createBoardRequest(@Valid @RequestBody CreateBoardRequest request){

        System.out.println("bbbb");

        boardService.create(request);
    }

    @GetMapping("/boards")
    public List<BoardResponse> findAll(){
        return boardService.findAll();
    }

    @DeleteMapping("/boards/{todoId}")
    public void delete(@PathVariable long id){
        boardService.delete(id);
    }

    @PutMapping ("/boards/{todoId}")
    public void edit(@PathVariable long id, @RequestBody CreateBoardRequest fixboard){
       boardService.edit(id, fixboard);
    }
}



