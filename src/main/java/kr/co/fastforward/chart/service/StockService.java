package kr.co.fastforward.chart.service;

import kr.co.fastforward.chart.domain.response.StockTradeHistory;

import java.util.List;

public interface StockService {

    /**
     * 외부 API 를 통한 주식 거래 정보를 가져온 후 DB 저장
     *
     * @param interval 조회 조건
     * @param range    조회 조건 - 날짜 범위
     */
    void loadTradeDataAndSave(String interval, String range);

    /**
     * 저장 된 거래 정보를 반환
     *
     * @return List<StockTradeHistory> - 거래 정보 목록
     */
    List<StockTradeHistory> getTradeHistories();
}
