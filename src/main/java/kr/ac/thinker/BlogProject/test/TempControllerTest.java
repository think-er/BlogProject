package kr.ac.thinker.BlogProject.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// 컨트롤러라는 어노테이션이 붙으면 파일을 리턴한다.
public class TempControllerTest {

    // http://localhost:8000/blog/temp/home
    @GetMapping("/temp/home")
    public String tempHome() {
        System.out.println("tempHome()");
        // 파일 리턴 기본 경로: src/main/resources/static
        // 리턴명: /home.html
        // 풀 경로: src/main/resources/static/home.html
        return "/home.html";
    }

    @GetMapping("/temp/img")
    public String tempImg() {
        return "/thinker.jpg";
    }

    // jsp 파일을 못찾는 이유는 jsp는 정적파일이 아니라, 동적파일, 자바파일이기 때문이다.
    // 브라우저가 얘를 인식하지 못함.
    @GetMapping("/temp/jsp")
    public String tempJsp() {
        // prefix : /WEB-INF/views/
        // suffix : .jsp
        // 풀 네임 : /WEB-INF/views//test.jsp.jsp
//        return "/test.jsp";
        return "test";
    }
}
