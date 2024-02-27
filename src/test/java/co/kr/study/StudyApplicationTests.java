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
		/**
		 * 1) create()
		 *
		 *
		 *
		 *
		 * 2) option build()
		 *
		 */
		//give


		System.out.println("Spring Junit TEST START");
		webClientService.get();
		System.out.println("Spring Junit TEST END");
	}


}
