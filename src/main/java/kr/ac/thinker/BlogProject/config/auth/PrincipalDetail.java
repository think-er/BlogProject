package kr.ac.thinker.BlogProject.config.auth;

import kr.ac.thinker.BlogProject.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/*
스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
스프링 시큐리티의 고유한 세션 저장소에 저장을 해준다.
PrincipalDetail을 DI할 것이다.
*/

public class PrincipalDetail implements UserDetails {

    private User user; // 콤포지션

    public PrincipalDetail(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    // 계정이 만료되지 않았는지 리턴한다. (true: 만료안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있는지 않았는지 리턴한다. (true: 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호가 만료되지 않았는지 리턴한다. (true: 만료 안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화(사용가능)인지 리턴한다. (true: 활성화됨)
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 계정이 갖고 있는 권한 목록을 리턴한다. (권한이 여러개 있을 수 있어서 루프를 돌아야하는데 우리는 한개만)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collecters = new ArrayList<>();
        /*collecters.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                // ROLE_ <- 스프링에서 ROLE을 받을 때 규칙임, 이렇게 해야함
                // ROLE_USER
                return "ROLE_" + user.getRole();
            }
        });*/

        collecters.add(() -> {
           return "ROLE_" + user.getRole();
        });

        return collecters;
    }
}
