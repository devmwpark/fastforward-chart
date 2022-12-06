package kr.co.fastforward.chart.exception;

import kr.co.fastforward.chart.type.MessageType;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = FeignException.class)
    protected ResponseEntity<Object> feignExceptionHandler(FeignException feignException) {
        log.error(feignException.getMessage());
        return new ResponseEntity<>(MessageType.STOCK_CLIENT_FAILED.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
