package bridge.condition;

import java.util.List;

public class ConditionGenerator {

    private ConditionGenerator() {
    }

    public static List<Condition> getBridgeSizeCondition() {
        return List.of(
                IsNumberInRangeCond.getInstance()
        );
    }

    public static List<Condition> getGameActionCondition() {
        return List.of(
                IsValidGameActionCond.getInstance()
        );
    }

    public static List<Condition> getSystemActionCondition() {
        return List.of(
                IsValidSystemActionCond.getInstance()
        );
    }
}
