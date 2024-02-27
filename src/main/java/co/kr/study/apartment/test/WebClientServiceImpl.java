package co.kr.study.apartment.test;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class WebClientServiceImpl {

    //WebClient 동작 테스트
    public void get() {
        String code = "myCode";

        // webClient 기본 설정
        String serviceKey = "dc5a8905-257c-4707-b489-365dd03ea937";

       /**
        * https://garyj.tistory.com/22
        * ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                //codec Memory size unlimited 설정
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1))
                .build();
        * 2가지 생성 방식이 존재함
        * 1) create()를 통해서는 정상적으로 xml 데이터 가져옴
        * 2) build()를 통한 데이터 가져오는 방식은 현재 문제가 있음... 원인을 못찾는중..
        *
        *
        */


        WebClient webClient = WebClient
                .builder()
                //.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl("http://api.kcisa.kr/openapi/API_TOU_050/request")
                .build()
                .mutate().build();

        Mono<String> result = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("serviceKey","dc5a8905-257c-4707-b489-365dd03ea937")
                        .queryParam("numOfRows","10")
                        .queryParam("pageNo","1")
                        .build())
                .retrieve()
                .bodyToMono(String.class);
               /* .uri("http://api.kcisa.kr/openapi/API_TOU_050/request?serviceKey=" + serviceKey+"&pageNo=1&numOfRows=1")
                .retrieve()
                .bodyToMono(String.class);
*/
        /*String result = WebClient.create("http://api.kcisa.kr")
                .get()
                .uri("/openapi/API_TOU_050/request?serviceKey=" + serviceKey+"&pageNo=1&numOfRows=1")
                .retrieve()
                .bodyToMono(String.class)
                .block();*/
        // 결과 확인
        //log.info(result.toString());
        log.info("ssssss");
    }


}
