package kr.ac.thinker.BlogProject.controller.api;

import kr.ac.thinker.BlogProject.config.auth.PrincipalDetail;
import kr.ac.thinker.BlogProject.dto.ResponseDto;
import kr.ac.thinker.BlogProject.model.Board;
import kr.ac.thinker.BlogProject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> saveItem(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
        boardService.saveBoard(board, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteItemById(@PathVariable int id) {
        boardService.deleteBoard(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
