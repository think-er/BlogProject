package kr.ac.thinker.BlogProject.handler;

import kr.ac.thinker.BlogProject.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    // Exception이 발생했을 때 이 함수를 실행시키려면 어디서든 Exception이 발생해도 이쪽으로 하기 위해서
    // 어노테이션 추가해야한다. -> ControllerAdvice
    @ExceptionHandler(value = Exception.class)
    public ResponseDto<String> handleArgumentException(Exception e) {
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
