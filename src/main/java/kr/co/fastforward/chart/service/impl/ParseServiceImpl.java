package kr.co.fastforward.chart.service.impl;

import kr.co.fastforward.chart.domain.external.StockTrade;
import kr.co.fastforward.chart.service.ParseService;
import kr.co.fastforward.chart.type.StockTradeKeyType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParseServiceImpl implements ParseService {

    private final ObjectMapper objectMapper;

    @Override
    public List<StockTrade> stockTradeData(final String jsonStringData) {
        try {
            final Map<String, Object> convertDataMap = this.objectMapper.readValue(jsonStringData, Map.class);
            final Map<String, Object> result = this.getResultDataMap(convertDataMap);
            final List<Object> quote = this.getQuoteDataList(result);

            final List<Integer> timestamps = this.getTimestampFromJsonData(result);
            final List<Double> highPrices = this.getHighPrices(quote);
            final List<Double> lowPrices = this.getLowPrices(quote);
            final List<Double> openPrices = this.getOpenPrices(quote);
            final List<Double> closePrices =this.getClosePrices(quote);
            final List<Integer> volumes = this.getVolumes(quote);

            final List<StockTrade> stockTrades = new ArrayList<>();
            for (int i = 0; i < timestamps.size(); i++) {
                stockTrades.add(StockTrade.builder()
                        .timestamp(timestamps.get(i))
                        .highPrice(highPrices.get(i))
                        .lowPrice(lowPrices.get(i))
                        .closePrice(closePrices.get(i))
                        .openPrice(openPrices.get(i))
                        .volume(volumes.get(i))
                        .build());
            }

            return stockTrades;

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return Collections.emptyList();
        }
    }

    private Map<String, Object> getResultDataMap(Map<String, Object> convertDataMap) {
        final Map<String, Object> chartMap = (Map<String, Object>) convertDataMap.get(StockTradeKeyType.CHART.getKeyName());
        return (Map<String, Object>) ((List<Object>) chartMap.get(StockTradeKeyType.RESULT.getKeyName())).get(0);
    }

    private List<Object> getQuoteDataList(Map<String, Object> result) {
        final Map<String, Object> indicators = (Map<String, Object>) result.get(StockTradeKeyType.INDICATORS.getKeyName());
        return (List<Object>) indicators.get(StockTradeKeyType.QUOTE.getKeyName());
    }

    private List<Integer> getTimestampFromJsonData(Map<String, Object> result) {
        return (List<Integer>) result.get(StockTradeKeyType.TIME_STAMP.getKeyName());
    }

    private List<Double> getHighPrices(List<Object> quote) {
        return (List<Double>) ((Map<String, Object>) quote.get(0)).get(StockTradeKeyType.HIGH.getKeyName());
    }

    private List<Double> getLowPrices(List<Object> quote) {
        return (List<Double>) ((Map<String, Object>) quote.get(0)).get(StockTradeKeyType.LOW.getKeyName());
    }

    private List<Double> getClosePrices(List<Object> quote) {
        return (List<Double>) ((Map<String, Object>) quote.get(0)).get(StockTradeKeyType.CLOSE.getKeyName());
    }

    private List<Double> getOpenPrices(List<Object> quote) {
        return (List<Double>) ((Map<String, Object>) quote.get(0)).get(StockTradeKeyType.OPEN.getKeyName());
    }

    private List<Integer> getVolumes(List<Object> quote) {
        return (List<Integer>) ((Map<String, Object>) quote.get(0)).get(StockTradeKeyType.VOLUME.getKeyName());
    }

}
