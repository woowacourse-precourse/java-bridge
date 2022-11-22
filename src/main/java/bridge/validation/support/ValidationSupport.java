package bridge.validation.support;

import bridge.dto.InputValidationDto.Request;
import java.util.Arrays;

public abstract class ValidationSupport {

    public boolean isExceptedLetter(final Request request, final String... expectedLetters) {
        return Arrays.stream(expectedLetters)
            .anyMatch(expectedLetter -> request.getTarget().equals(expectedLetter));
    }
}
