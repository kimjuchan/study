package co.kr.study;

import co.kr.study.apartment.test.WebClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.http.HttpClient;

@SpringBootTest
class StudyApplicationTests {

	@Autowired
	//@MockBean
	private WebClientServiceImpl webClientService;


	@Test
	void WebClientGet(){


		//WebClinet 2가지 생성방식
		//1번 일단 해당 내용은 외부 URL 호출하는 방식은  TEST에서 진행하면 ....불가능 ?
		System.out.println("Spring Junit TEST START");
		webClientService.get();
		System.out.println("Spring Junit TEST END");
	}


}
