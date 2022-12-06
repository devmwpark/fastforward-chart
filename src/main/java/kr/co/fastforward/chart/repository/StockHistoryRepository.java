package kr.co.fastforward.chart.repository;

import kr.co.fastforward.chart.entity.StockHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockHistoryRepository extends JpaRepository<StockHistory, Long> {
}
