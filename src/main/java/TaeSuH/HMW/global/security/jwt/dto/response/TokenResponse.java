package TaeSuH.HMW.global.security.jwt.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
@Builder
@Getter
public class TokenResponse {
    private String accessToken;
    private String refreshToken;
    private LocalDateTime expired_at;

    protected TokenResponse() {};
}
