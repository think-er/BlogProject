package kr.ac.thinker.BlogProject.config.auth;

import kr.ac.thinker.BlogProject.model.User;
import kr.ac.thinker.BlogProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 빈 등록
@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // 스프링이 로그인 요청을 가로챌 때, userName, passoword 변수 2개를 가로채는데
    // password 처리는 알아서해준다.
    // 해당 userName이 DB에 있는지만 확인해서 return 해주면 된다. -> 아래 함수에서
    // 이것을 안만들어주면 Spring Security의 기본으로 된다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername () 작동 : " + username);
        User principal = userRepository.findByUserName(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : " + username);
                });
        return new PrincipalDetail(principal); // 시큐리티의 세션에 유저 정보가 저장이 됨
    }
}
