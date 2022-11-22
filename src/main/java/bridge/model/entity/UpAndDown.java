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
        if(move != 0 && move != 1) {
            throw new IllegalArgumentException("[ERROR] 0, 1 이외의 값이 들어왔습니다");
        }
    }

}
