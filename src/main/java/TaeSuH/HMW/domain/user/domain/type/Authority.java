package TaeSuH.HMW.domain.user.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Authority {
    ROLE_STUDENT("student"), ROLE_TEACHER("teacher");

    private final String role;
}
