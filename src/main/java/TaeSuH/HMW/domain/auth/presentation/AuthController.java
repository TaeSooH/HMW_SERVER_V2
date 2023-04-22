package TaeSuH.HMW.domain.auth.presentation;

import TaeSuH.HMW.domain.auth.presentation.dto.request.RefreshTokenRequest;
import TaeSuH.HMW.domain.user.service.UserLoginOrUpdateService;
import TaeSuH.HMW.domain.user.service.UserLogoutService;
import TaeSuH.HMW.global.security.jwt.dto.response.TokenResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserLogoutService userLogoutService;
    private final UserLoginOrUpdateService userLoginOrUpdateService;

    @PostMapping("/bsm")
    public TokenResponse oauth(HttpServletRequest request) {
        return userLoginOrUpdateService.execute(request.getHeader("authCode"));
    }

    @DeleteMapping("/logout")
    public void logout(@RequestBody RefreshTokenRequest request) {
        userLogoutService.execute(request.getRefreshToken());
    }
}
