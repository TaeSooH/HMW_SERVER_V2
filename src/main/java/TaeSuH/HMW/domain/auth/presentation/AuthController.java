package TaeSuH.HMW.domain.auth.presentation;

import TaeSuH.HMW.domain.auth.presentation.dto.request.LoginRequest;
import TaeSuH.HMW.domain.auth.presentation.dto.request.RefreshTokenRequest;
import TaeSuH.HMW.domain.auth.presentation.dto.request.SignupRequest;
import TaeSuH.HMW.domain.user.service.UserLoginService;
import TaeSuH.HMW.domain.user.service.UserLogoutService;
import TaeSuH.HMW.domain.user.service.UserSignupService;
import TaeSuH.HMW.global.security.jwt.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserSignupService userSignupService;
    private final UserLoginService userLoginService;
    private final UserLogoutService userLogoutService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        userSignupService.execute(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return userLoginService.execute(request);
    }

    @DeleteMapping("/logout")
    public void logout(@RequestBody RefreshTokenRequest request) {
        userLogoutService.execute(request.getRefreshToken());
    }
}
