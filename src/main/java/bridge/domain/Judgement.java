package bridge.domain;

import java.util.List;
import java.util.Objects;

public class Judgement {
    public static boolean checkResult(List<Integer> movingSuccess) {
        return movingSuccess.get(movingSuccess.size() - 1) == 0 || movingSuccess.get(movingSuccess.size() - 1) == 2;
    }

    public static boolean checkRestart(String restart) {
        return Objects.equals(restart, "R");
    }
}
