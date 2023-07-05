package kr.ac.thinker.BlogProject.service;

import kr.ac.thinker.BlogProject.model.User;
import kr.ac.thinker.BlogProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해준다. IoC를 해준다.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public int save(User user) {
        try {
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserService : save() : " + e.getMessage());
        }
        return -1;
    }


}
