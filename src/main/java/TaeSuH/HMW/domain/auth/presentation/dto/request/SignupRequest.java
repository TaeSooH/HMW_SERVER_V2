package TaeSuH.HMW.domain.auth.presentation.dto.request;

import lombok.Getter;

@Getter
public class SignupRequest {
    private String email;
    private String name;
    private String password;
    private String passwordCheck;
}
