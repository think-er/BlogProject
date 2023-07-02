package kr.ac.thinker.BlogProject.test;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    // 상태는 메서드에 의해서 변경되게 해야한다. 상태를 바로 변경하는 것은? -> 마법이다.
    private int id;
    private String userName;
    private String password;
    private String email;
}
