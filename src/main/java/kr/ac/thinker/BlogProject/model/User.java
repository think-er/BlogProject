package kr.ac.thinker.BlogProject.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
// User 클래스가 MySQL에 테이블을 생성이 된다.
@Entity
// Insert 할 때 null 인 필드를 제외시켜준다.
// 근데 annotation 덕지덕지 붙이면 나중에 끝도 없다.
// 실력보다는 팁같은 것들을 많이 알게 되겠지만 결코 좋은 방법은 아니다.
//@DynamicInsert
public class User {

    @Id // Primary Key
    // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    // 만약 오라클을 연결한다면 시퀀스를 사용한다는 것
    // 만약 MySQL을 연결한다면 auto_increment를 사용한다는 것
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 시퀀스, auto_increment

    @Column(nullable = false, length = 30, unique = true)
    private String userName;

    // 123456 -> 해쉬 (비밀번호 암호화)
    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    // Enum을 쓰면 도메인(데이터의 범위)을 설정할 수 있다. 3개 중에 하나만 할 수 있도록

/*    insert
            into
    User
            (createDate, email, password, role, userName)
    values
            (?, ?, ?, null, ?)*/
    // 위처럼 적으면 기본값이 들어가지 않고, null값이 들어가게 된다.

    /*    insert
            into
    User
            (createDate, email, password, userName)
    values
            (?, ?, ?, ?)*/
    // 이렇게 해야 기본값이 들어가게 될 것이다. <- 이렇게 없애서 Insert 하는 방법을 찾아야함

    // Enum을 쓰는게 좋다. // admin, user, manager (managerrrrr)
    // 타입에 넣을 수 있는 데이터를 강제할 수 있다. (USER, ADMIN)
    // DB는 RoleType이라는게 없기 때문에 해당 Enum이 String이라고 알려준다.
//    @ColumnDefault("'user'")
    // 그냥 @Colum 안붙여도 알아서 필드가 생성된다. Colum 어노테이션이랑 상관없는듯.
    @Enumerated(EnumType.STRING)
    private RoleType role;

    // 자바에서 현재 시간을 넣고 INSERT 해준다.
    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate;
}
