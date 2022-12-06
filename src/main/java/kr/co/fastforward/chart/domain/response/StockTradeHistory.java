package kr.co.fastforward.chart.domain.response;

import kr.co.fastforward.chart.entity.StockHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class StockTradeHistory {

    @ApiModelProperty("ID")
    private final Long id;

    @ApiModelProperty("최고 가격")
    private final Double highPrice;

    @ApiModelProperty("최저 가격")
    private final Double lowPrice;

    @ApiModelProperty("개장 가격")
    private final Double openPrice;

    @ApiModelProperty("종전 가격")
    private final Double closePrice;

    @ApiModelProperty("거래량")
    private final Integer volume;

    @ApiModelProperty("거래 일시")
    private final String tradingAt;

    public static StockTradeHistory StockHistoryOf(StockHistory stockHistory) {
        return StockTradeHistory.builder()
                .id(stockHistory.getId())
                .highPrice(stockHistory.getHighPrice())
                .lowPrice(stockHistory.getLowPrice())
                .openPrice(stockHistory.getOpenPrice())
                .closePrice(stockHistory.getClosePrice())
                .volume(stockHistory.getVolume())
                .tradingAt(stockHistory.getTimestamp().toString())
                .build();
    }
}
