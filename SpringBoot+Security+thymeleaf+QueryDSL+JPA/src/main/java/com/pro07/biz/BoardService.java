package com.pro07.biz;

import com.pro07.dto.BoardDTO;
import com.pro07.dto.PageRequestDTO;
import com.pro07.dto.PageResponseDTO;

public interface BoardService {
    public Long register(BoardDTO boardDTO);
    public BoardDTO selectOne(Long seq);
    public void modify(BoardDTO boardDTO);
    public void remove(Long seq);
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);

}
