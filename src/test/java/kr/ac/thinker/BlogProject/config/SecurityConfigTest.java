package kr.ac.thinker.BlogProject.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class SecurityConfigTest {

    @Test
    void encodePWD() {
        // 고정길이의 문자열로 바꿔준다.
        String encPassword = new BCryptPasswordEncoder().encode("1234");
        System.out.println("1234 해쉬 : " + encPassword);
    }
}
