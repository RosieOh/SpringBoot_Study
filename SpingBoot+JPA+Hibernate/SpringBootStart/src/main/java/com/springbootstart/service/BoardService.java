package com.springbootstart.service;

import com.springbootstart.domain.Board;
import com.springbootstart.dto.BoardDTO;

// 465P 부터 시작
public interface BoardService {

    Long register(BoardDTO boardDTO);

    BoardDTO readOne(Long bno);

    void modify(BoardDTO boardDTO);

    void remove(Long bno);
}
