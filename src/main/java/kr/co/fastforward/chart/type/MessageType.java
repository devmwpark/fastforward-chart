package kr.co.fastforward.chart.type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum MessageType {

    STOCK_CLIENT_FAILED("거래 정보를 가져 올 수 없습니다.\n잠시후 다시 시도 바랍니다."),
    STOCK_TRADE_LOAD_DATA_EMPTY("저장 할 거래 정보가 존재하지 않습니다.");

    private final String message;
}
