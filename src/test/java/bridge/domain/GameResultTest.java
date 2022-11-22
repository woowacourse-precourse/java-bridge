package bridge.domain;

import static org.assertj.core.util.Lists.newArrayList;

import bridge.validator.Validator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    private GameResult gameResult;
    private BridgeMatcher bridgeMatcher;

    @Test
    @DisplayName("게임 결과를 생성하는 기능 테스트")
    void makeBridgeResult() {
        List<Boolean> boolBridge = newArrayList();
        String expected = "[ O |   ]\n" + "[   | X ]\n";

        gameResult = new GameResult("", "");
        bridgeMatcher = new BridgeMatcher(boolBridge, 1);

        gameResult.makeBridgeResult(Validator.MOVE_UP, true, bridgeMatcher);
        String actual = gameResult.makeBridgeResult(Validator.MOVE_DOWN, false, bridgeMatcher);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}