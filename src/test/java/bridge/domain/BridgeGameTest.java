package bridge.domain;

import static org.assertj.core.util.Lists.newArrayList;

import bridge.validator.Validator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }

    @Test
    @DisplayName("사용자가 칸을 이동할 때 사용하는 기능 테스트")
    void move() {
        List<String> bridege = newArrayList("U", "U", "D");
        String input = Validator.MOVE_UP;
        List<Boolean> boolBridge = newArrayList();
        BridgeMatcher bridgeMatcher = new BridgeMatcher(boolBridge);

        boolean expected = true;
        boolean actual = bridgeGame.move(bridege, input, bridgeMatcher);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}