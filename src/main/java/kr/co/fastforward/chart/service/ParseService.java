package kr.co.fastforward.chart.service;

import kr.co.fastforward.chart.domain.external.StockTrade;

import java.util.List;

public interface ParseService {

    /**
     * Json 형태의 String Data 를 정해진 Key Value 를 이용하여 Object 로 변환
     *
     * @param jsonStringData Json 형태의 String Data
     * @return 주식거래 정보 목록
     */
    List<StockTrade> stockTradeData(final String jsonStringData);
}
