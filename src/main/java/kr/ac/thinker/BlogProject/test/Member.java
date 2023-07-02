package kr.ac.thinker.BlogProject.test;

import lombok.*;

@Data
@NoArgsConstructor
public class Member {

    // 상태는 메서드에 의해서 변경되게 해야한다. 상태를 바로 변경하는 것은? -> 마법이다.
    private int id;
    private String userName;
    private String password;
    private String email;

    @Builder
    public Member(int id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

}
