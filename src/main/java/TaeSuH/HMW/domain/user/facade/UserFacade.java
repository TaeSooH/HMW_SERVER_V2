package TaeSuH.HMW.domain.user.facade;

import TaeSuH.HMW.domain.auth.presentation.dto.request.SignupRequest;
import TaeSuH.HMW.domain.user.domain.Repository.UserRepository;
import TaeSuH.HMW.domain.user.domain.User;
import TaeSuH.HMW.domain.user.domain.type.Authority;
import TaeSuH.HMW.domain.user.domain.type.StuNumber;
import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void passwordCheck(String password, String passwordCheck) {
        if(!password.equals(passwordCheck)) throw new IllegalArgumentException("패스워드가 다릅니다.");
    }

    public User saveUser(BsmUserResource resource) {
        switch (resource.getRole()) {
            case STUDENT -> {
                return userRepository.save(User.builder()
                        .email(resource.getEmail())
                        .name(resource.getStudent().getName())
                        .stuNumber(StuNumber.builder()
                                .ban(resource.getStudent().getClassNo())
                                .grade(resource.getStudent().getGrade())
                                .num(resource.getStudent().getStudentNo())
                                .build())
                        .authority(Authority.ROLE_STUDENT)
                        .build()
                );
            }
            case TEACHER -> {
                return userRepository.save(User.builder()
                        .email(resource.getEmail())
                        .name(resource.getTeacher().getName())
                        .authority(Authority.ROLE_TEACHER)
                        .build()
                );
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    public void checkEncodedPassword(String originalPassword, String encodedPassword) {
        if(!passwordEncoder.matches(originalPassword, encodedPassword)){
            throw new IllegalArgumentException("not same");
        }
    }
}
