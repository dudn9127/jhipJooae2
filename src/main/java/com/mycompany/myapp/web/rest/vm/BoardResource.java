package com.mycompany.myapp.web.rest.vm;

import com.mycompany.myapp.domain.Board;
import com.mycompany.myapp.repository.BoardRepository;
import com.mycompany.myapp.service.BoardService;
import com.mycompany.myapp.service.dto.BoardDTO;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardResource {

    private final Logger log = LoggerFactory.getLogger(BoardResource.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    public BoardResource(BoardService boardService, BoardRepository boardRepository) {
        this.boardService = boardService;
        this.boardRepository = boardRepository;
    }

    @GetMapping("/board")
    public ResponseEntity<List<BoardDTO>> getAllBoard(Pageable pageable){
        final Page<BoardDTO> page = boardService.getAllBoard(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(),page);
        return new ResponseEntity<>(page.getContent(),headers, HttpStatus.OK);
    }

    @PostMapping("/board")
    public ResponseEntity<Board> createPost(@Valid @RequestBody BoardDTO boardDTO) throws URISyntaxException {
        Board newBoard = boardService.createBoard(boardDTO);
        return ResponseEntity.created(new URI("/api/board/")).body(newBoard);
    }

}
