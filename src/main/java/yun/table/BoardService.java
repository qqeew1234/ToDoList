package yun.table;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void create(CreateBoardRequest request) {
        boardRepository.save(new Board(request.name()));
    }

    public List<BoardResponse> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(board -> new BoardResponse(
                        board.getId(),
                        board.getName()))
                .toList();
    }

    public void delete(long id) {
        boardRepository.deleteById(id);
    }

    public void edit(long id, CreateBoardRequest fixboard) {
        Board board = boardRepository.findById(id).orElseThrow();
        board.edit(fixboard);
        boardRepository.save(board);
    }
}
