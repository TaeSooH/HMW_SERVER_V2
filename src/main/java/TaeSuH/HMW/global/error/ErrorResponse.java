package TaeSuH.HMW.global.error;

import TaeSuH.HMW.global.error.exception.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;

    public String toString(){
        return "{\n" +
                "\t\"status\": " + status +
                "\n\t\"message\": " + message +
                "\n}";
    }

    public ErrorResponse(ErrorProperty errorProperty) {
        this.status = errorProperty.getStatus();
        this.message = errorProperty.getMessage();
    }
}
