package TaeSuH.HMW.domain.user.facade;

import TaeSuH.HMW.domain.auth.presentation.dto.request.SignupRequest;
import TaeSuH.HMW.domain.user.domain.Repository.UserRepository;
import TaeSuH.HMW.domain.user.domain.User;
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

    public void saveUser(SignupRequest request) {
        userRepository.save(User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .build()
        );
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
