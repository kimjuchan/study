package co.kr.study.department.domain;


import co.kr.study.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dept_id")
    private int id;

    @Column(nullable = false, length = 100)
    private String deptName;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "department")
    private List<User> usersiList;


    public Department(String deptName, String content) {
        this.deptName = deptName;
        this.content = content;
    }
}
