package kr.ac.thinker.BlogProject.repository;

import kr.ac.thinker.BlogProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// 해당 JPA 리포지토리는 유저 테이블이 관리하고, 유저 테이블의 PK의 도메인은 Integer이다.
// Data Access Object (DAO)
// 자동으로 bean 등록이 된다.
//@Repository // 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {
    // 로그인을 위한 함수
    // JPA 네이밍 전략
    // select * from user where userName = ?(매개변수) and password = ?;
    // User findByUserNameAndPassword(String userName, String password);

/*    // nativeQuery?????????
    @Query(value = "SELECT * FROM user WHERE userName = ?1 AND password = ?2", nativeQuery = true)
    User login(String userName, String password);*/

    // SELECT * FROM user WHERE userName = 1?;
    Optional<User> findByUserName(String userName);
}
