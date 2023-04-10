package TaeSuH.HMW.domain.user.service;

import TaeSuH.HMW.domain.auth.presentation.dto.request.LoginRequest;
import TaeSuH.HMW.domain.user.domain.User;
import TaeSuH.HMW.domain.user.facade.UserFacade;
import TaeSuH.HMW.global.security.jwt.JwtTokenProvider;
import TaeSuH.HMW.global.security.jwt.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(LoginRequest request) {
        User user = userFacade.findByEmail(request.getEmail());
        userFacade.checkEncodedPassword(request.getPassword(), user.getPassword());
        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getEmail()))
                .refreshToken(jwtTokenProvider.createRefreshToken(user.getEmail()))
                .expired_at(jwtTokenProvider.getExpiredAt())
                .build();
    }
}
