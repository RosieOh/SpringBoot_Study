package com.pro07.per;

import com.pro07.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    Page<Board> searchOne(Pageable pageable);
    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);

}
