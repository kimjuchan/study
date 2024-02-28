package co.kr.study.apartment.test;


import co.kr.study.department.domain.Department;
import co.kr.study.department.repository.DepartmentRepository;
import co.kr.study.user.domain.User;
import co.kr.study.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;


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

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    @GetMapping("/test")
    public void test(){

            //DEPARTMENT // USER 연관관계 설정 관련 테스트.

            Department departmentA = Department.builder().deptName("depA").content("A").build();
            Department departmentB = Department.builder().deptName("depB").content("B").build();
            Department departmentC = Department.builder().deptName("depC").content("C").build();
            Department departmentD = Department.builder().deptName("depD").content("D").build();

            String deptsList = "ABCD";
            Random random = new Random();

            departmentRepository.save(departmentA);
            departmentRepository.save(departmentB);
            departmentRepository.save(departmentC);
            departmentRepository.save(departmentD);


            for(int i=0; i<50; i++){
                int randomValue = (int) (Math.random() * 4) + 1;
                User usersi =
                        User.builder()
                                .memSex((i%2) > 0 ? "F" : "M")
                                //홀수일경우만 결혼g
                                .memMarried((i%2) > 0 ? "Y" : "N")
                                .memPhoneNm("010-1234-123"+i)
                                .memEmail("user"+i+"@naver.com")
                                .build();
                userRepository.save(usersi);
                System.out.println("randomValue :: "  +randomValue );
                switch (randomValue){
                    case 1 : usersi.setDepartment(departmentA); break;
                    case 2 : usersi.setDepartment(departmentB); break;
                    case 3 : usersi.setDepartment(departmentC); break;
                    case 4 : usersi.setDepartment(departmentD); break;
                }

            }
            List<User> usersiList = userRepository.findAll();
            usersiList.forEach(user -> {
                System.out.println("user Dept : "+ user.getDepartment().getDeptName() + "  || user email : " + user.getMemEmail() + "  || user id : " + user.getId());
            });

    }



    @GetMapping("/data/list")
    public String getOpenApiList(){
        return webClientService.get();
    }

}
