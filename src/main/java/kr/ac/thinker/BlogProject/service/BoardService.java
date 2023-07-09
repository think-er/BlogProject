package kr.ac.thinker.BlogProject.service;

import kr.ac.thinker.BlogProject.model.Board;
import kr.ac.thinker.BlogProject.model.User;
import kr.ac.thinker.BlogProject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해준다. IoC를 해준다.
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    // 글쓰기 하려면 유저 정보 필요한데? 유저정보 어디?????
    @Transactional
    public void saveBoard(Board board, User user) { // title, content
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> getBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board getBoardById(int id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
                });
    }

    @Transactional
    public void deleteBoard(int id) {
        boardRepository.deleteById(id);
    }
}
