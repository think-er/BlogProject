package kr.ac.thinker.BlogProject.service;

import kr.ac.thinker.BlogProject.model.RoleType;
import kr.ac.thinker.BlogProject.model.User;
import kr.ac.thinker.BlogProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// 스프링 프레임워크의 트랜잭션
import org.springframework.transaction.annotation.Transactional;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해준다. IoC를 해준다.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void save(User user) {
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

    // select 할 때 transaction 시작, 서비스 종료 시에 트랜잭션 종료 (정합성)
/*    @Transactional(readOnly = true)
    public User login(User user) {
        return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
    }*/




}
