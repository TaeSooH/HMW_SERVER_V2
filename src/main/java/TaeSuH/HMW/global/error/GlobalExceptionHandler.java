package TaeSuH.HMW.global.error;

import TaeSuH.HMW.global.error.exception.ErrorProperty;
import TaeSuH.HMW.global.error.exception.HMWException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({HMWException.class})
    public ResponseEntity<ErrorResponse> handelGlobal(HMWException e) {
        ErrorProperty errorProperty = e.getErrorProperty();
        return new  ResponseEntity<>(
                new ErrorResponse(
                        errorProperty.getStatus(),
                        errorProperty.getMessage()),
                HttpStatus.valueOf(errorProperty.getStatus())
        );
    }

    @ExceptionHandler({BindException.class})
    public ResponseEntity<?> bindException(BindException e) {
        Map<String, String> errorMap = new HashMap<>();

        for (FieldError error : e.getFieldErrors()) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> constraintViolationException(ConstraintViolationException e) {
        Map<String, String> errorMap = new HashMap<>();

        for (ConstraintViolation<?> error: e.getConstraintViolations()) {
            errorMap.put("constraint error", error.getMessage());
        }
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
