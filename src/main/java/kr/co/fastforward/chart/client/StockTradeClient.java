package kr.co.fastforward.chart.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stock-trade-client", url = "${stock-trade.client.url}")
public interface StockTradeClient {

    @GetMapping
    String getTradeHistory(@RequestParam String interval, @RequestParam String range);
}
