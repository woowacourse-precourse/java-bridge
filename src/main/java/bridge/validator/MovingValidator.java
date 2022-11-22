package bridge.validator;

import bridge.Moving;
import bridge.exception.WrongMovingException;
import java.util.Arrays;

public class MovingValidator {

    public static void validateMoving(String moving) {
        Arrays.stream(Moving.values())
                .filter(v -> moving.equals(v.getCode()))
                .findFirst()
                .orElseThrow(WrongMovingException::new);
    }
}
