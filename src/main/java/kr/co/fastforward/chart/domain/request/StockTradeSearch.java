package kr.co.fastforward.chart.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class StockTradeSearch {

    @ApiModelProperty(value = "범위", required = true)
    private String interval;

    @ApiModelProperty(value = "기간", required = true)
    private String range;
}
