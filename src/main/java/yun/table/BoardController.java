package yun.table;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}



