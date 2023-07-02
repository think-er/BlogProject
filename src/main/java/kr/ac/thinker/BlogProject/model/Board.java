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

    // 기본 전략 (EAGER 전략)
    @ManyToOne(fetch = FetchType.EAGER) // M : 1, Many = Board : One = User
    @JoinColumn(name = "userId")
    private User user;

    // 기본 전략 (LAZY 전략)
    // 상세 보기 창에서 댓글을 숨기지 않고, 전부 보여줄 것임 -> EAGER
    // 펼치기 버튼을 클릭하기 전에 댓글을 보여줄 필요 없음 -> LAZY
    // mappBy = "필드이름"
    // DB에 컬럼을 만들지마라
    // mappedBy 가 적혀있으면 연관관계의 주인이 아니다. (난 FK가 아니에요)
    // 그냥 Board를 Select 할 때 join문을 통해서 값을 얻기 위해서 필요한 것이다.
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
