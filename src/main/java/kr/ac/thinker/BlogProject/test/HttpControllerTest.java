package kr.ac.thinker.BlogProject.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(HTML 파일)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest : ";

    @GetMapping("/http/lombok")
    public String lombokTest() {
//        Member m = new Member(1, "thinker", "1234", "thinker@gmail.com");

        // 생성자의 매개변수 위치를 외울 필요가 없음. 
        Member m = Member.builder().userName("thinker").password("1234").email("thinker@gmail.com").build();
        System.out.println(TAG + "getter : " + m.getId());
        m.setId(5000);
        System.out.println(TAG + "setter : " + m.getId());

        Member m2 = new Member();
        m2.setId(2);
        m2.setUserName("thinker2");
        m2.setPassword("5678");
        m2.setEmail("thinker2@gmail.com");

        System.out.println(TAG + "setter : " + m2.getId());

        return "lombok test 완료";
    }


    // 인터넷 브라우저 요청은 무조건 get요청 밖에 할 수 없다.
    // http://localhost:8080/http/get (SELECT)
    @GetMapping("/http/get")
    public String getTest(
            //            @RequestParam int id, @RequestParam String userName
            // MessageConverter (스프링부트) -> 요청 쿼리 스트링 부를 오브젝트에 매핑시켜주는 역할
            Member m) {
        return "get 요청 " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword()
                + ", " + m.getEmail();
    }

    // http://localhost:8080/http/post (INSERT)
    @PostMapping("/http/post")
    public String postTest(
            // Member m // 데이터를 요청 바디 부에 담아서 보냄. (x-www-form-urlencoded)
            // @RequestBody String text // text/plain
            @RequestBody Member m // application/json
            // MessageConverter (스프링부트) -> 요청 바디 부를 오브젝트에 매핑시켜주는 역할
        ) {
        return "post 요청 " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword()
                + ", " + m.getEmail();
//        return "post 요청 " + text;
    }

    // http://localhost:8080/http/put (UPDATE)
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청 " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword()
                + ", " + m.getEmail();
    }

    // http://localhost:8080/http/delete (DELETE)
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
