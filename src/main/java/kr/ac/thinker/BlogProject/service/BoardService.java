package kr.ac.thinker.BlogProject.service;

import kr.ac.thinker.BlogProject.model.Board;
import kr.ac.thinker.BlogProject.model.RoleType;
import kr.ac.thinker.BlogProject.model.User;
import kr.ac.thinker.BlogProject.repository.BoardRepository;
import kr.ac.thinker.BlogProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해준다. IoC를 해준다.
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    // 글쓰기 하려면 유저 정보 필요한데? 유저정보 어디?????
    @Transactional
    public void save(Board board, User user) { // title, content
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    public List<Board> getList() {
        return boardRepository.findAll();
    }
}
