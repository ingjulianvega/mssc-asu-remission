package ingjulianvega.ximic.msscasuremission.exception;

import lombok.Getter;

@Getter
public class RemissionException extends RuntimeException {

    private final String code;

    public RemissionException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

