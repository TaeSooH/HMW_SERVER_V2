package TaeSuH.HMW.domain.user.service;

import TaeSuH.HMW.domain.auth.service.OauthGetResourceService;
import TaeSuH.HMW.domain.user.domain.Repository.UserRepository;
import TaeSuH.HMW.domain.user.domain.User;
import TaeSuH.HMW.domain.user.facade.UserFacade;
import TaeSuH.HMW.global.security.jwt.JwtTokenProvider;
import TaeSuH.HMW.global.security.jwt.dto.response.TokenResponse;
import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserLoginOrUpdateService {

    private final OauthGetResourceService oauthGetResourceService;
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(String authCode) {
        User user = saveOrUpdate(oauthGetResourceService.execute(authCode));
        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getEmail()))
                .refreshToken(jwtTokenProvider.createRefreshToken(user.getEmail()))
                .expire_at(jwtTokenProvider.getExpiredAt())
                .build();
    }

    private User saveOrUpdate(BsmUserResource resource) {
        Optional<User> user = userRepository.findByEmail(resource.getEmail());
        if(user.isEmpty()) {
            return userFacade.saveUser(resource);
        }
        else return user.get().update(resource);
    }
}
