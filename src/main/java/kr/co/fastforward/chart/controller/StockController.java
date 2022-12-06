package kr.co.fastforward.chart.controller;

import io.swagger.annotations.ApiParam;
import kr.co.fastforward.chart.domain.request.StockTradeSearch;
import kr.co.fastforward.chart.domain.response.StockTradeHistory;
import kr.co.fastforward.chart.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock-trade")
@Api(tags = {"거래 정보 API"})
public class StockController {

    private final StockService stockService;

    @PostMapping("/histories")
    @ApiOperation(value = "거래 정보 저장")
    public ResponseEntity<Object> loadTradeData(@RequestBody @ApiParam StockTradeSearch stockTradeSearch) {
        this.stockService.loadTradeDataAndSave(stockTradeSearch.getInterval(), stockTradeSearch.getRange());
        return new ResponseEntity<>("정상 처리되었습니다.", HttpStatus.OK);
    }

    @GetMapping("/histories")
    @ApiOperation(value = "거래 정보 조회", response = StockTradeHistory.class)
    public ResponseEntity<List<StockTradeHistory>> getTradeHistory() {
        return new ResponseEntity<>(this.stockService.getTradeHistories(), HttpStatus.OK);
    }
}
