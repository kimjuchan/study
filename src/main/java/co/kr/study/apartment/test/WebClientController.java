package co.kr.study.apartment.test;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Apratment getRTMSDataSvcAptTradeDev(아파트 매매 신고 상세자료 조회)
 * 요청 url http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?LAWD_CD=11110&DEAL_YMD=201512&serviceKey=서비스키
 *
 */
@RestController
@RequestMapping("/open/api")
@RequiredArgsConstructor
public class WebClientController {

    private final WebClientServiceImpl webClientService;
    @GetMapping("/data/list")
    public String getOpenApiList(){
        return webClientService.get();
    }

}
