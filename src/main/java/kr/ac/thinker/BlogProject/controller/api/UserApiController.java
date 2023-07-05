package kr.ac.thinker.BlogProject.controller.api;

import kr.ac.thinker.BlogProject.dto.ResponseDto;
import kr.ac.thinker.BlogProject.model.RoleType;
import kr.ac.thinker.BlogProject.model.User;
import kr.ac.thinker.BlogProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    // DI(Dependency Injection)
    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) { // userName, password, email
        System.out.println("UserApiController : save 호출됨");
        user.setRole(RoleType.USER);
        int result = userService.save(user);
        // 자바 오브젝트를 JSON으로 변환해서 리턴 (Jackson)
        return new ResponseDto<Integer>(HttpStatus.OK, result);
    }
}
