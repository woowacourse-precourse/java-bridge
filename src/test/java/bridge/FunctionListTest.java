package bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.model.BridgeGame;
import bridge.model.Progress;
import bridge.model.constant.BridgePattern;
import bridge.model.constant.GameCondition;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FunctionListTest {

    private final Progress progress = new Progress(5);
    private final BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U", "D", "U"), progress);

    // BridgeGame 클래스에 대한 테스트
    @DisplayName("move 메소드가 성공적으로 실행되는 케이스")
    @Test
    public void moveSuccess() {
        assertEquals(bridgeGame.move(BridgePattern.MOVE_UP), GameCondition.IN_PROGRESS);
        assertEquals(bridgeGame.move(BridgePattern.MOVE_DOWN), GameCondition.IN_PROGRESS);
        assertEquals(bridgeGame.move(BridgePattern.MOVE_UP), GameCondition.IN_PROGRESS);
        assertEquals(bridgeGame.move(BridgePattern.MOVE_DOWN), GameCondition.IN_PROGRESS);
        assertEquals(bridgeGame.move(BridgePattern.MOVE_UP), GameCondition.GOAL);

        assertEquals(progress.getProgress(), generateCompareMap());
    }

    @DisplayName("move 메소드가 실패하는 케이스")
    @Test
    public void moveFail() {
        assertEquals(bridgeGame.move(BridgePattern.MOVE_DOWN), GameCondition.FAILURE);
        assertEquals(progress.getProgress().get(BridgePattern.MOVE_DOWN), new ArrayList<>() {{ add("X");}});
    }

    private Map<BridgePattern, List<String>> generateCompareMap() {
        List<String> up = new ArrayList<>() {{
            add("O");
            add(" ");
            add("O");
            add(" ");
            add("O");
        }};
        List<String> down = new ArrayList<>() {{
            add(" ");
            add("O");
            add(" ");
            add("O");
            add(" ");
        }};

        return new EnumMap<>(BridgePattern.class) {{
            put(BridgePattern.MOVE_UP, up);
            put(BridgePattern.MOVE_DOWN, down);
        }};
    }
}
