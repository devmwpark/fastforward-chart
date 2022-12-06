package kr.co.fastforward.chart.type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum StockTradeKeyType {
    CHART("chart"),
    RESULT("result"),
    TIME_STAMP("timestamp"),
    INDICATORS("indicators"),
    QUOTE("quote"),
    HIGH("high"),
    LOW("low"),
    CLOSE("close"),
    VOLUME("volume"),
    OPEN("open");

    private final String keyName;
}
