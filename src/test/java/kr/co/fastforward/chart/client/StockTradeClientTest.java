package kr.co.fastforward.chart.client;

import kr.co.fastforward.chart.type.StockTradeKeyType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class StockTradeClientTest {

    @Autowired
    private StockTradeClient stockTradeClient;

    @Test
    @DisplayName("주식 거래 정보 호출 정상")
    public void call_success() {
        final String interval = "1d";
        final String range = "5d";

        String result = this.stockTradeClient.getTradeHistory(interval, range);

        assertTrue(result.contains(StockTradeKeyType.TIME_STAMP.getKeyName()));
        assertTrue(result.contains(StockTradeKeyType.LOW.getKeyName()));
        assertTrue(result.contains(StockTradeKeyType.HIGH.getKeyName()));
        assertTrue(result.contains(StockTradeKeyType.CLOSE.getKeyName()));
        assertTrue(result.contains(StockTradeKeyType.OPEN.getKeyName()));
        assertTrue(result.contains(StockTradeKeyType.VOLUME.getKeyName()));
    }
}
