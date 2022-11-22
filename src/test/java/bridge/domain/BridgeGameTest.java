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
        List<String> bridege = newArrayList("U", "U", "D");
        List<Boolean> boolBridge = newArrayList();
        BridgeMatcher bridgeMatcher = new BridgeMatcher(boolBridge, 1);
        bridgeGame = new BridgeGame(bridege, bridgeMatcher);
    }

    @Test
    @DisplayName("사용자가 칸을 이동할 때 사용하는 기능 테스트")
    void move_test1() {
        String input = Validator.MOVE_UP;

        boolean expected = true;
        boolean actual = bridgeGame.move(input);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사용자가 칸을 이동할 때 사용하는 기능 테스트")
    void move_test2() {
        String input = Validator.MOVE_DOWN;

        boolean expected = false;
        boolean actual = bridgeGame.move(input);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}