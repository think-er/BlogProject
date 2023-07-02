package kr.ac.thinker.BlogProject.test;

import kr.ac.thinker.BlogProject.model.RoleType;
import kr.ac.thinker.BlogProject.model.User;
import kr.ac.thinker.BlogProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    @Autowired // 의존성 주입
    private UserRepository userRepository;

    // http://localhost:8000/blog/dummy/join (요청)
    // http의 body에 userName, password, email 데이터를 가지고 (요청)
    @PostMapping("/dummy/join")
    public String join(
//            String userName, String password, String email
            User user
    ) { // key = value (약속된 규칙)
        // x-www-form-urlencoded 로 전송되는 방식은 스프링이 함수의 파라미터로 파싱해서 넣어준다.
//        System.out.println("userName: " + userName);
//        System.out.println("password: " + password);
//        System.out.println("email: " + email);

        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUserName());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("role: " + user.getRole());
        System.out.println("createDate: " + user.getCreateDate());

        // 개발자들이 실수를 할수도 있음 -> user2 (?) 열거형, Enum 필요
//        user.setRole("user");
        user.setRole(RoleType.USER);

        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
