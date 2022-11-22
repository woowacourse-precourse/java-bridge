package bridge.exception.domain;

import bridge.utils.message.ExceptionMessageUtils;

public class WrongGeneratorException extends RuntimeException {

    public WrongGeneratorException() {
        super(ExceptionMessageUtils.WRONG_GENERATOR.getMessage());
    }
}
