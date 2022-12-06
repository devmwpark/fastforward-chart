package kr.co.fastforward.chart.exception;

import lombok.Getter;

@Getter
public class LoadDataEmptyException extends RuntimeException {

    private final String message;

    public LoadDataEmptyException(String message) {
        this.message = message;
    }
}
