package com.springbootstart.service;

import com.springbootstart.dto.BoardDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
                .title("오늘은 JPA 공부했지롱")
                .content("JPA 독학하니 할만하노")
                .writer("오태훈")
                .build();

        Long bno = boardService.register(boardDTO);

        log.info("bno : " + bno);
    }
}