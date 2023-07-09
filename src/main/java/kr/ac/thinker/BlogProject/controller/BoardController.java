package kr.ac.thinker.BlogProject.controller;

import kr.ac.thinker.BlogProject.config.auth.PrincipalDetail;
import kr.ac.thinker.BlogProject.model.Board;
import kr.ac.thinker.BlogProject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 컨트롤러에서 세션을 어떻게 찾는지?
    // 근데 이렇게 하면 controller에서 세션을 어떻게 확인하고 다른 창을 보여주는거지?
    @GetMapping({"","/"})
    public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)
    Pageable pageable) {
        Page<Board> boardPage = boardService.getBoardList(pageable);
        List<Board> boardList = boardPage.getContent();
        model.addAttribute("boards", boardPage);
        return "index"; // viewResolver 작동!!!
    }

    @GetMapping("/board/{id}")
    public String getItemById(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.getBoardById(id));
        return "board/detail";
    }

    // USER 권한이 필요
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
