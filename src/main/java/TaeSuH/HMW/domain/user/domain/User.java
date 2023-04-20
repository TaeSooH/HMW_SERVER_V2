package TaeSuH.HMW.domain.user.domain;

import TaeSuH.HMW.domain.user.domain.type.Authority;
import TaeSuH.HMW.domain.user.domain.type.StuNumber;
import jakarta.persistence.*;
import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String name;

    @Embedded
    private StuNumber stuNumber;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    protected User() {};

    @Builder
    public User(Long id, String email, String name, StuNumber stuNumber, Authority authority) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.stuNumber = stuNumber;
        this.authority = authority;
    }


    public User update(BsmUserResource resource) {
        switch (resource.getRole()) {
            case STUDENT -> {
                this.email = resource.getEmail();
                this.name = resource.getStudent().getName();
                this.stuNumber = StuNumber.builder()
                        .grade(resource.getStudent().getGrade())
                        .ban(resource.getStudent().getClassNo())
                        .num(resource.getStudent().getStudentNo())
                        .build();
            }
            case TEACHER -> {
                this.email = resource.getEmail();
                this.name = resource.getTeacher().getName();
            }
        }
        return this;
    }
}
