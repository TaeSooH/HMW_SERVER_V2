package TaeSuH.HMW.domain.user.service;

import TaeSuH.HMW.domain.auth.presentation.dto.request.SignupRequest;
import TaeSuH.HMW.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignupService {

    private final UserFacade userFacade;

    public void execute(SignupRequest request) {
        userFacade.passwordCheck(request.getPassword(), request.getPasswordCheck());
        userFacade.saveUser(request);
    }
}
