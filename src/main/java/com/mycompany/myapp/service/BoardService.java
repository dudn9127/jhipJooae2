package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Board;
import com.mycompany.myapp.repository.BoardRepository;
import com.mycompany.myapp.service.dto.BoardDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board writeBoard(BoardDTO boardDTO){
        Board newBoard = new Board();
        newBoard.setTitle(boardDTO.getTitle());
        newBoard.setContent(boardDTO.getContent());
        newBoard.setImageUrl(boardDTO.getImageUrl());
        boardRepository.save(newBoard);
        return newBoard;
    }

    public void deleteBoard(Long id){
        boardRepository.delete(boardRepository.findOneById(id));
    }

    @Transactional(readOnly = true)
    public Page<BoardDTO> getAllBoard(Pageable pageable){
        return boardRepository.findAll(pageable).map(BoardDTO::new);

    }

    public Board createBoard(BoardDTO boardDTO){
        Board board = new Board();
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setImageUrl(boardDTO.getImageUrl());
        boardRepository.save(board);
        log.debug("Created Information for Board:{}", board);
        return board;
    }

}
