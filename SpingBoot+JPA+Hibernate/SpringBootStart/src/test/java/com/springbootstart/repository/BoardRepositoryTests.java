package com.springbootstart.repository;

import com.springbootstart.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

//    @Test
//    public void testInsert() {
//        IntStream.rangeClosed(1, 100).forEach(i -> {
//            Board board = Board.builder()
//                    .title("title..." + i)
//                    .content("content..." + i)
//                    .writer("user" + (i % 10))
//                    .build();
//
//            Board result = boardRepository.save(board);
//        });
//    }

    // select 기능 테스트
    @Test
    public void testSelect() {
        Long bno = 100L;

        Optional<Board> result =boardRepository.findById(bno);

        Board board = result.orElseThrow();

    }
}