package TaeSuH.HMW.domain.wordSet.presentation;

import TaeSuH.HMW.domain.wordSet.presentation.dto.request.WordSetCreateByUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wordSet")
@RequiredArgsConstructor
public class WordSetController {

    @PostMapping("/createByUser")
    public void createWordSet(@RequestBody WordSetCreateByUserRequest request) {
    }
}
