package kr.ac.thinker.BlogProject.controller.api;

import kr.ac.thinker.BlogProject.dto.ResponseDto;
import kr.ac.thinker.BlogProject.model.RoleType;
import kr.ac.thinker.BlogProject.model.User;
import kr.ac.thinker.BlogProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    // DI(Dependency Injection)
    @Autowired
    private UserService userService;

    // 세션 객체는 스프링 컨테이너가 빈으로 등록해서 가지고 있다.
    // 필요하다면 DI로 받아서 사용할 수 있다.
/*    @Autowired
    private HttpSession session;*/

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) { // userName, password, email
        System.out.println("UserApiController : save 호출됨");
        userService.save(user);
        // 자바 오브젝트를 JSON으로 변환해서 리턴 (Jackson)
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

/*    // 전통적인 로그인 방식 -> 스프링 시큐리티를 이용해서 로그인 할 예정
    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user
//                                      , HttpSession session
    ) {
        System.out.println("UserApiController : login 호출됨");
        User principal = userService.login(user); // 접근주체???

        if(principal != null) {
            session.setAttribute("principal", principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }*/
}
