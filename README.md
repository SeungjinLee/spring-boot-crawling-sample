# spring-boot-crawling-sample
네이버 주식 크롤링을 만들어보고 Spring Boot를 사용해 Rest API 구현

* 기술 스펙
  * Spring Tool Suite 4.14.0
  * Openjdk-11
  * Spring boot 2.6.5
  * Jpa
  * H2 database 

***

## 개발 과정

* **Junit**을 사용하여 네이버주식 크롤링 작성
  * Jsoup라이브러리 활용 
* 크롤링한 목록을 담을 수 있는 VO를 작성
* 크롤링을 실행하는 API 작성
  * `@Bean` 생성 후 크롤링한 목록 담기
  * `@GetMapping`을 사용해 API 작성
* 크롤링된 목록을 조회하는 API 작성(메모리에 담겨져있는)
* **JPA**를 활용하여 **H2데이터베이스**를 연결해보고 크롤링한 데이터 등록 - 리펙토링
* DB에 있는 데이터 조회 - 리펙토링
* `@Scheduled`를 활용하여 자동으로 크롤링할 수 있는 스케줄러 작성
* 주식데이터를 직접 등록할 수 있는 `@PostMapping` API 작성
  * `@Valid`를 활용하여 요청데이터 유효성 검증
  * `@ControllerAdvice`를 활용하여 예외 처리
  * Junit에서 `@AutoConfigureMockMvc`를 사용하여 API 테스트
* **AOP**를 사용하여 실행시간 로그 출력
  * 어노테이션 방식의 `pointcut`를 사용하여 필요한 부분에만 출력
* API 응답데이터 - 리펙토링
  * 하드코딩되어있는 결과코드 **Enum** 타입으로 변경
  * **빌더패턴**을 사용하여 응답코드 유연하게 변경

***
## cors 오류 문제
* 인덱스 파일
  * [index.html](https://github.com/SeungjinLee/spring-boot-crawling-sample/blob/master/index.html)
* 크롬 브라우저에서 실행 후 `F12`로 개발자모드 열어서 cors 오류 확인하시고 `spring boot`에서 설정으로 해결해 보세요

