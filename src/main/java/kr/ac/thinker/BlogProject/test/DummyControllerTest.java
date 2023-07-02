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

        // 요청: 웹 브라우저한테 특정 id의 유저 정보를 달라고 GET요청을 한다.
        // user 객체는 자바 오브젝트이다.
        // user 객체를 웹 브라우저에게 리턴한다.
        // 웹 브라우저: 아니 이게뭐임? ㅋㅋㅋ
        // 웹 브라우저는 user 객체를 이해하지 못할 것이다. -> 웹 브라우저가 이해할 수 있는 데이터로 변환을 해야한다. (JSON)
        // Gson이라는 라이브러리가 자바 오브젝트를 json으로 변경해서 던져줬다.
        // 스프링 부트 = MessageConverter라는 애가 응답시에 자동 작동
        // 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
        // user 오브젝트를 json으로 변환해서 브라우저에게 던져준다.


        /*
        * 웹 브라우저에서 특정 ID의 유저 정보를 요청하는 GET 요청을 받았을 때,
        * 스프링 부트는 해당 유저 정보를 자바 객체로 반환합니다.
        * 그러나 웹 브라우저는 자바 객체를 이해할 수 없기 때문에,
        * 스프링 부트의 MessageConverter가 동작하여 응답을 JSON 형식으로 변환해 웹 브라우저에게 전달합니다.

        * 일반적으로 스프링 부트에서는 MessageConverter를 사용하여 자바 객체를 원하는 형식으로 변환합니다.
        * JSON 형식의 변환은 주로 Jackson 라이브러리를 사용합니다.
        * MessageConverter는 응답 시에 자동으로 동작하여, 컨트롤러에서 반환된 자바 객체를 확인하고
        * 해당 객체를 Jackson 라이브러리를 통해 JSON 형식으로 변환합니다.
        * 그리고 이 JSON 데이터를 웹 브라우저에게 전달하여 표시할 수 있도록 합니다.

        결과적으로, 스프링 부트의 MessageConverter는 자바 객체를 JSON으로 변환하여
        * 웹 브라우저에게 전달하는 역할을 담당합니다. 이를 통해 웹 브라우저는 받은 JSON 데이터를
        * 해석하고 원하는 방식으로 화면에 표시할 수 있습니다.
        * */


        /*
        * 클라이언트(웹 브라우저)에서 HTTP 요청을 보내면,
        * 해당 요청은 스프링 부트의 컨트롤러에 도달합니다. 컨트롤러는 해당 요청을 처리하고,
        * 처리 결과를 HTTP 응답으로 반환합니다. 이 HTTP 응답은 다시 클라이언트(웹 브라우저)에게
        * 전송되어 표시됩니다.

        스프링 부트는 컨트롤러에서 반환된 정보를 적절한 형식으로 변환하여 클라이언트에게 전달합니다.
        * 이때 주로 JSON 형식이 사용되며,
        * 스프링 부트의 MessageConverter를 통해 자바 객체를 JSON으로 변환하여 HTTP 응답의 바디 부분에
        * 포함시킵니다. 웹 브라우저는 이러한 HTTP 응답을 수신하고, JSON 데이터를 해석하여 화면에 표시합니다.

        따라서, 스프링 부트는 클라이언트(웹 브라우저)에게 정보를 리턴하는 역할을 수행하며,
        * 이를 위해 HTTP 응답을 생성하고 변환하여 클라이언트에게 전송합니다.
        * */

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
