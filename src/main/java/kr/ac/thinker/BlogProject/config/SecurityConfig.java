package kr.ac.thinker.BlogProject.config;

import kr.ac.thinker.BlogProject.config.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 아래 3가지는 세트이다.
// 빈 등록: 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration
// 시큐리티 필터 등록 = 스프링 시큐리티가 활성화되어 있긴한데 어떤 설정을 해당 파일에서 하겠다.
@EnableWebSecurity
/* 특정 주소로 접근하면 권한 및 인증을 미리 체크하겠다는 뜻
= 어떤 요청이 들어오면 요청을 수행하고 시큐리티 동작하는게 아니라는 것
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;

    // IoC가 된다.
    // 이 함수가 리턴하는 값은 앞으로 스프링이 관리한다.
    // 필요할 때마다 가져와서 쓰면 된다.
    @Bean
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }

    // 시큐리티가 대신 로그인해주는데 password를 가로채기하는데
    // 해당 패스워드가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
    // 같은 해쉬로 암호화해서 DB에 있는 해쉬와 비교할 수 있다.
    // 사용자 인증을 처리하는 방법을 구성하는 데 사용

    /*
    *
    * 로그인 시 사용자가 입력한 비밀번호를 데이터베이스에 저장된 비밀번호와 비교하기 위해서는
    * 동일한 방식으로 암호화해야 합니다.
    *
    * 일반적으로는 사용자의 비밀번호를 해시 함수를 사용하여 암호화하여 저장합니다.
    * 이 때, 같은 비밀번호는 항상 동일한 해시 값으로 변환됩니다.
    * 따라서 로그인 시에도 입력한 비밀번호를 동일한 해시 함수를 사용하여 암호화한 후,
    * 데이터베이스에 저장된 해시와 비교해야 합니다. 만약 두 해시 값이 일치한다면,
    * 입력한 비밀번호가 올바르다는 의미입니다.
    *
    * 따라서, 로그인 시에는 입력한 비밀번호를 암호화한 후,
    * 데이터베이스에 저장된 해시 값과 비교하여 인증을 수행합니다.
    * 이를 위해 사용자 인증 처리 과정에서 동일한 암호화 방식을 사용하여 비밀번호를 처리하도록 설정해야 합니다.
    *
    * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 사용자 세부 정보 서비스를 설정하지 않은 것입니다.
        // 실제로 사용자 세부 정보 서비스 구현체를 전달해야합니다.

        // 사용자가 정의한 비밀번호 인코딩 방식에 따라 비밀번호를 인코딩하여 저장하고,
        // 사용자 인증 시에 비밀번호를 확인하는 데 사용
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }

    // Spring Security를 사용하여 웹 애플리케이션의 보안 설정을 구성하는 데 사용
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // csrf 토큰 비활성화 (테스트시 걸어두는게 좋음)
            .authorizeRequests()
                // 이러한 주소로 들어오면
                .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**", "/test/**")
                // 요청을 허용하고
                .permitAll()
                // 그게 아닌 모든 주소는
                .anyRequest()
                // 인증이 필요하다.
                .authenticated()
            .and()
                .formLogin()
                .loginPage("/auth/loginForm")
                .loginProcessingUrl("/auth/loginProc") // 스프링 시큐리티가 해당 주소로 로그인을 가로채서 대신 로그인해준다.
                .defaultSuccessUrl("/") // 정상적으로 요청이 완료가 되면 해당 url로 이동
                // 기본값인걸 나는 수정하겠다!!!!!!!!!!!!!!!!
                .usernameParameter("userName");
    }
}
