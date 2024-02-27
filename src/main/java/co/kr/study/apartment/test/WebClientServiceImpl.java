package co.kr.study.apartment.test;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class WebClientServiceImpl {

    //WebClient 동작 테스트
    public String get() {

        // webClient 기본 설정
        String serviceKey = "dc5a8905-257c-4707-b489-365dd03ea937";
        final String[] result_async = new String[1];

       /**
        * https://garyj.tistory.com/22
        * ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                //codec Memory size unlimited 설정
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1))
                .build();
        * 2가지 생성 방식이 존재함
        * 1) create()를 통해서는 정상적으로 xml 데이터 가져옴
        * 2) build()를 통한 데이터 가져오는 방식
        *  ->*** queryParam 값 따로 설정해줘야함 (처음에는 url String 값 자체에 모두 적용해줬는데 인식을 못했음..)
        */

        /**
         * 1) create() 생성 방식
         String result = WebClient.create("http://api.kcisa.kr")
         .get()
         .uri("/openapi/API_TOU_050/request?serviceKey=" + serviceKey+"&pageNo=1&numOfRows=1")
         .retrieve()
         .bodyToMono(String.class)
         .block();
         */

        WebClient webClient = WebClient
                .builder()
                //.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl("http://api.kcisa.kr")
                .build()
                .mutate().build();
        //
        // Mono<String> result =
        String result_sync = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/openapi/API_TOU_050/request")
                        .queryParam("serviceKey","dc5a8905-257c-4707-b489-365dd03ea937")
                        .queryParam("numOfRows","10")
                        .queryParam("pageNo","1")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                //동기 처리
                .block();

        String responseXml = result_sync.toString();
        JSONObject jsonObject = XML.toJSONObject(responseXml);
        String responseJson = jsonObject.toString();
        System.out.println("ㄴopen API Response :: >> ");
        System.out.println(responseJson);
        System.out.println("-------------------------");

        result_sync = responseJson;

                //비동기 처리
                /* .subscribe(response -> {
                    // 정상적인 응답 처리 로직
                    try{
                        *//**
                         *
                         *  기본적으로 Jackson을 통해서  XML to JsonNode  -> JsonNode to Json 형태로 형변환을 해도됨
                         *      EX) JsonNode jsonNode = xmlMapper.readTree(xmlString);
                         *          //JsonNode를 JSON 문자열로 변환
                         *          ObjectMapper jsonMapper = new ObjectMapper();
                         *          jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
                         *  2번째로 가볍고 간단한 라이브러리 사용해서 구현 방법 : org.json  사용 (현재 사용방식)
                         *
                         *  문제) 람다 표현식 안에서는  final 선언된 변수만 접근 가능  (지역변수 접근 불가능 ...처음에는 지역변수에 response 값 저장해서 return 해주려고함 에러 발생)
                         *  문제 2) 변수를 final 형태로 선언하다보니  람다 표현식 안에서 접근은 가능한데 값을 바꿀 수 없음.
                         *  해결) 선언을 final 형태 + 배열 형태로
                         *  JAVA에서 Effective Final 이라는 개념이 도입되면서   final 키워드 선언 변수를 변경하기 위해서는 배열 값으로 선언 후 해당 변경 값을 넣어줘야함.
                         *  배열은 final형태로 선언되어도 내부 요소 값은 변경 가능.
                         *//*
                        String responseXml = response.toString();
                        JSONObject jsonObject = XML.toJSONObject(responseXml);
                        ObjectMapper mapper = new ObjectMapper();
                        String responseJson = jsonObject.toString();
                        System.out.println("ㄴopen API Response :: >> ");
                        System.out.println(responseJson);
                        System.out.println("-------------------------");

                        // 추후에 예를 들어서 여기서 조회한 데이터를 내부 DB에 INSERT ,UPDATE 진행
                        result_async[0] = responseJson;
                        return result_async[0];

                    }catch (Exception e){
                        log.info("XML to JSON 형변환 오류 발생");
                    }
                });*/
        return result_sync;
    }


}
