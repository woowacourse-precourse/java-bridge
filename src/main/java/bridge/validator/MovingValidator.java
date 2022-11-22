package bridge.validator;

import bridge.Row;
import bridge.exception.WrongMovingException;
import java.util.Arrays;

public class MovingValidator {

    public static void validateMoving(String moving) {
        Arrays.stream(Row.values())
                .filter(row -> moving.equals(row.getCode()))
                .findFirst()
                .orElseThrow(WrongMovingException::new);
    }
}
