package TaeSuH.HMW.domain.user.service;

import TaeSuH.HMW.domain.auth.domain.Repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLogoutService {

    private final RefreshTokenRepository refreshTokenRepository;

    public void execute(String token) {
        refreshTokenRepository.findById(token)
                .ifPresent(refreshTokenRepository::delete);
        SecurityContextHolder.clearContext();
    }
}
