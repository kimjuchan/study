package co.kr.study.user.domain;

import co.kr.study.department.domain.Department;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_id")
    private int id;

    @Column
    //성별 : M , F
    private String memSex;
    @Column
    //결혼 여부 Y , N
    private String memMarried;
    @Column
    //차량 번호
    private String memPhoneNm;

    @Column
    private String memEmail;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

}
