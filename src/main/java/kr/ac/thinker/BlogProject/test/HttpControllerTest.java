package kr.ac.thinker.BlogProject.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(HTML 파일)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

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
