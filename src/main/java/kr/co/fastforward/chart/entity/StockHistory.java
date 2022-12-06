package kr.co.fastforward.chart.entity;

import kr.co.fastforward.chart.domain.external.StockTrade;
import kr.co.fastforward.chart.type.TradeCompanyType;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "stock_history",
        indexes = @Index(name = "uniq_idx_company_type_trade_at", columnList = "trade_company_type, timestamp", unique = true))
@Builder
@Getter
public class StockHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "high_price")
    private Double highPrice;

    @Column(name = "low_price")
    private Double lowPrice;

    @Column(name = "open_price")
    private Double openPrice;

    @Column(name = "close_price")
    private Double closePrice;

    @Column(name = "trade_company_type")
    private TradeCompanyType tradeCompanyType;

    @Column(name = "volume")
    private Integer volume;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public static StockHistory insertBuildFromStockTrade(StockTrade stockTrade) {
        final Timestamp timestamp = new Timestamp(stockTrade.getTimestamp() * 1000L);

        return StockHistory.builder()
                .highPrice(stockTrade.getHighPrice())
                .lowPrice(stockTrade.getLowPrice())
                .openPrice(stockTrade.getOpenPrice())
                .closePrice(stockTrade.getClosePrice())
                .tradeCompanyType(TradeCompanyType.SAMSUNG)
                .volume(stockTrade.getVolume())
                .timestamp(timestamp)
                .build();
    }
}
