package kr.ac.thinker.BlogProject.repository;

import kr.ac.thinker.BlogProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 해당 JPA 리포지토리는 유저 테이블이 관리하고, 유저 테이블의 PK의 도메인은 Integer이다.
// Data Access Object (DAO)
// 자동으로 bean 등록이 된다.
//@Repository // 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
