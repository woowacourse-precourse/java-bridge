package bridge.model.value;

import java.util.HashMap;
import java.util.Map;

import static bridge.model.value.ErrorMessage.NOT_BIT_ERROR;
import static bridge.model.value.ErrorMessage.getMessage;

public class UpAndDown {
    private static final Map<Integer, String> direction = new HashMap<>(
        Map.of(0, "D", 1, "U")
    );
    public static String getDirection(Integer move) {
        validate(move);
        return direction.get(move);
    }

    private static void validate(Integer move){
        if(move != 0 && move != 1) {
            throw new IllegalArgumentException(getMessage(NOT_BIT_ERROR));
        }
    }

}
