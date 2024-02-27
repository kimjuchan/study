/*
package co.kr.study.apartment.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Slf4j
public class WebClientConfig {

    @Bean
    public void webClientCreate(){
        String serviceKey = "dc5a8905-257c-4707-b489-365dd03ea937";
        WebClient webClient = WebClient
                .builder()
                //.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl("http://api.kcisa.kr/openapi/API_TOU_050/request?serviceKey=" + serviceKey)
                .build()
                .mutate().build();
        log.info("create WebClient info !!!!");
        log.info("create WebClient BASE URL :: " + webClient.get().toString());
    }
}
*/
