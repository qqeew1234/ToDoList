package yun.table;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void create(@Valid CreateBoardRequest request) {
        boardRepository.save(new Board(request.name()));
    }
}
