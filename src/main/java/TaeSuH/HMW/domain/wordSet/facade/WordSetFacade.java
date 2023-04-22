package TaeSuH.HMW.domain.wordSet.facade;

import TaeSuH.HMW.domain.user.domain.User;
import TaeSuH.HMW.domain.user.facade.UserFacade;
import TaeSuH.HMW.domain.wordSet.domain.WordSet;
import TaeSuH.HMW.domain.wordSet.domain.repository.WordSetRepository;
import TaeSuH.HMW.domain.wordSet.presentation.dto.request.WordSetCreateByUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class WordSetFacade {

    private final WordSetRepository wordSetRepository;

    @Transactional
    public WordSet createWordSet(WordSetCreateByUserRequest request, User user) {
        return wordSetRepository.save(
                WordSet.builder()
                        .title(request.getTitle())
                        .owner(user)
                        .build()
        );
    }
}
