package TaeSuH.HMW.global.security.jwt.exception;

import TaeSuH.HMW.global.error.exception.HMWException;
import TaeSuH.HMW.global.security.jwt.exception.error.JwtErrorProperty;

public class InvalidTokenException extends HMWException {

    public final static InvalidTokenException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(JwtErrorProperty.INVALID_TOKEN);
    }
}