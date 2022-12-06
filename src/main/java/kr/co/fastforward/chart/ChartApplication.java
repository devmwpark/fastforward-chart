package kr.co.fastforward.chart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChartApplication.class, args);
    }

}
