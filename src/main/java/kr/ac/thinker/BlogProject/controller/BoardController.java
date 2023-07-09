package kr.ac.thinker.BlogProject.controller;

import kr.ac.thinker.BlogProject.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({"","/"}) // 근데 이렇게 하면 controller에서 세션을 어떻게 확인하고 다른 창을 보여주는거지?
    public String index(@AuthenticationPrincipal PrincipalDetail principal) {
        // /WEB-INF/views/index(.jsp)
        System.out.println("로그인 사용자 아이디 : " + principal.getUsername());
        return "index";
    }
}
