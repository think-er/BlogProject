package kr.ac.thinker.BlogProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // 이러한 주소로 들어오면
                .antMatchers("/auth/**")
                // 요청을 허용하고
                .permitAll()
                // 그게 아닌 모든 주소는
                .anyRequest()
                // 인증이 필요하다.
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/loginForm");
    }
}
