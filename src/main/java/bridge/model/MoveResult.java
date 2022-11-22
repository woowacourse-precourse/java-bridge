package bridge.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

public enum MoveResult {

    LOWER_DIRECTION_SUCCESS("D", true, (upList, downList) -> makeSuccessBridge(downList, upList)),
    LOWER_DIRECTION_FAIL("D", false, (upList, downList) -> makeFailBridge(downList, upList)),
    UPPER_DIRECTION_SUCCESS("U", true, MoveResult::makeSuccessBridge),
    UPPER_DIRECTION_FAIL("U", false, MoveResult::makeFailBridge),
    EMPTY(null, false, null);


    private final String moving;
    private final boolean success;
    private final BiConsumer<List<String>, List<String>> expression;
    private static List<String> upBridge = new ArrayList<>();
    private static List<String> downBridge = new ArrayList<>();

    MoveResult(String moving, boolean success, BiConsumer<List<String>, List<String>> expression) {
        this.moving = moving;
        this.success = success;
        this.expression = expression;
    }

    public static void apply(String moving, boolean success) {
        Arrays.stream(MoveResult.values())
                .filter(directionTest -> directionTest.moving.equals(moving))
                .filter(directionTest -> directionTest.success == success)
                .findAny().get()
                .expression.accept(upBridge, downBridge);
    }

    public static void makeSuccessBridge(List<String> successBridge, List<String> spaceBridge) {
        successBridge.add("O");
        spaceBridge.add(" ");
    }

    public static void makeFailBridge(List<String> failBridge, List<String> spaceBridge) {
        failBridge.add("X");
        spaceBridge.add(" ");

    }

    public static List<String> getUpBridge() {
        return Collections.unmodifiableList(upBridge);
    }

    public static List<String> getDownBridge() {
        return Collections.unmodifiableList(downBridge);
    }

    public static void retrySetting() {
        upBridge.clear();
        downBridge.clear();
    }
}