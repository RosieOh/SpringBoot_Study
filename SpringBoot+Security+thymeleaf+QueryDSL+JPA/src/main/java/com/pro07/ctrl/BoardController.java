package com.pro07.ctrl;

import com.pro07.biz.BoardService;
import com.pro07.domain.Board;
import com.pro07.dto.BoardDTO;
import com.pro07.dto.PageRequestDTO;
import com.pro07.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("list.do")
    public String boardList(PageRequestDTO pageRequestDTO, Model model) throws Exception {
        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        log.info(responseDTO);
        model.addAttribute("responseDTO", responseDTO);
        return "/board/boardList";
    }

    @GetMapping("insert.do")
    public void boardInsert() {

    }

    @PostMapping("insert.do") {
        public String boardInsert(@Valid BoardDTO boardDTO)
    }
}
