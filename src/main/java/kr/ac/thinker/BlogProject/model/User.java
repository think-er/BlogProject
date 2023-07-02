package kr.ac.thinker.BlogProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
// User 클래스가 MySQL에 테이블을 생성이 된다.
@Entity
public class User {

    @Id // Primary Key
    // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    // 만약 오라클을 연결한다면 시퀀스를 사용한다는 것
    // 만약 MySQL을 연결한다면 auto_increment를 사용한다는 것
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 시퀀스, auto_increment

    @Column(nullable = false, length = 30)
    private String userName;

    // 123456 -> 해쉬 (비밀번호 암호화)
    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'user'")
    // Enum을 쓰면 도메인(데이터의 범위)을 설정할 수 있다. 3개 중에 하나만 할 수 있도록
    private String role; // Enum을 쓰는게 좋다. // admin, user, manager (managerrrrr)

    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate;
}
