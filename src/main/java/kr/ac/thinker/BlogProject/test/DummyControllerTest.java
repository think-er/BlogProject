package kr.ac.thinker.BlogProject.test;

import kr.ac.thinker.BlogProject.model.RoleType;
import kr.ac.thinker.BlogProject.model.User;
import kr.ac.thinker.BlogProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// html 파일이 아니라 data를 리턴해주는 컨트롤러 = RestController
@RestController
public class DummyControllerTest {

    @Autowired // 의존성 주입
    private UserRepository userRepository;


    // {id} 주소로 파라미터를 전달받을 수 있다.
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        // 반환형이 Optional<T>인 이유
        // user/4를 찾을 때 내가 데이터베이스에서 못찾으면 user가 null이 될 것이다.
        // return null이 될 것 -> 프로그램에 문제 발생 가능
        // Optional로 user객체를 감싸서 가져올테니 null인지 아닌지 판단해서 리턴해라.

        // 내가 받은 값이 절대 null일리 없다 그냥 뽑아내겠다 ㅋㅋ
//         User user = userRepository.findById(id).get();

        // 빈 객체 하나 만들어서 user에 넣어줘
        // user id가 벗어난 경우에도 반환
        // {"id":0,"userName":null,"password":null,"email":null,"role":null,"createDate":null}
/*        User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
            @Override
            public User get() {
                return new User();
            }
        });*/

/*        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
            }
        });*/

        // 람다식
        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
        });

        // 요청: 웹 브라우저
        // user 객체는 자바 오브젝트이다.
        // user 객체를 웹 브라우저한테 리턴한다.
        // 웹 브라우저: 아니 이걸 나보고 어떻게 리턴해라고 난 얘 모름 ㅋㅋㅋ
        // 웹 브라우저는 user 객체를 이해하지 못할 것이다. -> 웹 브라우저가 이해할 수 있는 데이터로 변환을 해야한다. (JSON)
        // Gson이라는 라이브러리가 자바 오브젝트를 json으로 변경해서 던져줬다.
        // 스프링 부트 = MessageConverter라는 애가 응답시에 자동 작동
        // 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
        // user 오브젝트를 json으로 변환해서 브라우저에게 던져준다.
        return user;
    }


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

        // 요청: 웹 브라우저
        // user 객체 = 자바 오브젝트
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
