package TaeSuH.HMW.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HMWException extends RuntimeException{

    private final ErrorProperty errorProperty;
}

