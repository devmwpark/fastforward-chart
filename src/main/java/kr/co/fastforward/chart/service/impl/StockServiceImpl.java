package kr.co.fastforward.chart.service.impl;

import kr.co.fastforward.chart.client.StockTradeClient;
import kr.co.fastforward.chart.domain.external.StockTrade;
import kr.co.fastforward.chart.domain.response.StockTradeHistory;
import kr.co.fastforward.chart.entity.StockHistory;
import kr.co.fastforward.chart.exception.LoadDataEmptyException;
import kr.co.fastforward.chart.repository.StockHistoryRepository;
import kr.co.fastforward.chart.service.ParseService;
import kr.co.fastforward.chart.service.StockService;
import kr.co.fastforward.chart.type.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockServiceImpl implements StockService {
    private final StockTradeClient stockTradeClient;
    private final ParseService parseService;

    private final StockHistoryRepository stockHistoryRepository;

    @Override
    @Transactional
    public void loadTradeDataAndSave(String interval, String range) {
        final String tradeJsonData = this.stockTradeClient.getTradeHistory(interval, range);
        final List<StockTrade> stockTrades = this.parseService.stockTradeData(tradeJsonData);

        if (stockTrades.isEmpty()) {
            throw new LoadDataEmptyException(MessageType.STOCK_TRADE_LOAD_DATA_EMPTY.getMessage());
        }

        for (StockTrade stockTrade : stockTrades) {
            try {
                this.stockHistoryRepository.save(StockHistory.insertBuildFromStockTrade(stockTrade));
            } catch (Exception e) {
                log.error(ExceptionUtils.getStackTrace(e));
            }
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<StockTradeHistory> getTradeHistories() {
        List<StockHistory> stockHistories = this.stockHistoryRepository.findAll();
        return stockHistories.stream().map(StockTradeHistory::StockHistoryOf).collect(Collectors.toList());
    }
}
