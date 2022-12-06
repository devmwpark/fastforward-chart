package kr.co.fastforward.chart.service;

import kr.co.fastforward.chart.client.StockTradeClient;
import kr.co.fastforward.chart.domain.external.StockTrade;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class ParseServiceTest {

    @Autowired
    private ParseService parseService;

    @Autowired
    private StockTradeClient stockTradeClient;

    @Test
    void stock_trade_data_parse_success() {
        // Given
        final String jsonStringData = this.stockTradeClient.getTradeHistory("1d", "5d");

        // When
        List<StockTrade> stockTrades = this.parseService.stockTradeData(jsonStringData);

        for (StockTrade stockTrade : stockTrades) {
            log.info(stockTrade.toString());
        }

        // Then
        assertFalse(stockTrades.isEmpty());
    }

    @Test
    void stock_trade_data_parse_fail() {
        // Given
        final String jsonStringData = "TEST FAILED";

        // When
        List<StockTrade> stockTrades = this.parseService.stockTradeData(jsonStringData);

        // Then
        assertTrue(stockTrades.isEmpty());
    }

}
