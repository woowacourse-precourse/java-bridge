package bridge.model.entity;

import java.util.HashMap;
import java.util.Map;

public class UpAndDown {
    private static final Map<Integer, String> direction = new HashMap<>(
        Map.of(0, "D", 1, "U")
    );
    public static String getDirection(Integer move) {
        validate(move);
        return direction.get(move);
    }

    private static void validate(Integer move){
        //TODO: 예외 작성
    }

}
