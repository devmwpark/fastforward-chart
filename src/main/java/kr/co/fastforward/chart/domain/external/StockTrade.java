package kr.co.fastforward.chart.domain.external;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@ToString
public class StockTrade {

    private final Integer timestamp;

    private final Double highPrice;

    private final Double lowPrice;

    private final Double closePrice;

    private final Double openPrice;

    private final Integer volume;
}
