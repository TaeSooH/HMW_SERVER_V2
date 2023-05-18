package TaeSuH.HMW.global.security.jwt.exception;

import TaeSuH.HMW.global.error.exception.HMWException;
import TaeSuH.HMW.global.security.jwt.exception.error.JwtErrorProperty;

public class ExpiredTokenException extends HMWException {

    public final static ExpiredTokenException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(JwtErrorProperty.EXPIRED_TOKEN);
    }
}

