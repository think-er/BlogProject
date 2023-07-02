package kr.ac.thinker.BlogProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
// ORM -> Java Object을 테이블과 매핑시켜주는 기술
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    // 내용은 엄청나게 길 수 있다.
    // 우리가 적는 일반적인 글이 디자인이 되서 들어가는데, 디자인이 될 때, html 태그가 섞여서 디자인 된다.
    // 글자 용량이 굉장히 커지기 때문에 대용량 데이터를 써야한다.
    @Lob // 대용량 데이터
    private String content; // 섬머 노트 라이브러리

    @ColumnDefault("0")
    private int count; // 조회수

    // 이 게시글을 누가 적었는지 알아야 한다.
    // ORM에서는 FK 값으로 찾는게 아니라 오브젝트를 넣으면 된다.
    // DB는 오브젝트를 저장할 수 없어서 FK 사용, 자바는 오브젝트를 저장할 수 있다.
    // private int userId;

    @ManyToOne // M : 1, Many = Board : One = User
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
