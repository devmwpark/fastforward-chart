# Project Version

---

- Java 11
- SpringBoot 2.7.7
- SpringCloud 2021.0.3

# Build Processor

---

Gradle

``gradle build``

# External Library

---

- apache commons lang3
- spring cloud open feign
- lombok
- H2 Database

# Project Document

---

swagger2

``localhost:8080/swagger-ui.html``

# ETC

---

- 프로젝트 실행 시 자동으로 H2 DataBase 에 테이블을 Drop -> Create 진행.

# 회고 및 개선이 필요한 부분

---

- 거래 데이터의 Json 크기가 커질 경우 시간복잡도를 고려한 파싱 방법으로 변경 필요.
- Exception Handling 에 대한 처리가 부족.
- Product Properties 의 Profile 별 설정 분리.
- Log 에 대한 처리 추가 필요.
