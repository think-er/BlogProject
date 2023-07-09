package kr.ac.thinker.BlogProject.controller;

import kr.ac.thinker.BlogProject.config.auth.PrincipalDetail;
import kr.ac.thinker.BlogProject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 컨트롤러에서 세션을 어떻게 찾는지?

    @GetMapping({"","/"}) // 근데 이렇게 하면 controller에서 세션을 어떻게 확인하고 다른 창을 보여주는거지?
    public String index(Model model) {
        model.addAttribute("boards", boardService.getList());
        return "index"; // viewResolver 작동!!!
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
