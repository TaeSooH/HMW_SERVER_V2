package TaeSuH.HMW.domain.wordSet.service;

import TaeSuH.HMW.domain.user.domain.User;
import TaeSuH.HMW.domain.user.facade.UserFacade;
import TaeSuH.HMW.domain.wordSet.domain.WordSet;
import TaeSuH.HMW.domain.wordSet.facade.WordSetFacade;
import TaeSuH.HMW.domain.wordSet.presentation.dto.request.WordSetCreateByUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WordSetCreateService {

    private final WordSetFacade wordSetFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(WordSetCreateByUserRequest request) {
        User user = userFacade.getCurrentUser();
        WordSet wordSet = wordSetFacade.createWordSet(request, user);
        wordSet.setUser(user);
    }
}
