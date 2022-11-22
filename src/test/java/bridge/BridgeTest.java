package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final int BRIDGE_SIZE = 3;
    private final Bridge bridge = new Bridge(bridgeMaker.makeBridge(BRIDGE_SIZE), new Player());
    private final BridgeGame bridgeGame = new BridgeGame(bridge);

    @DisplayName("U나 D가 입력 됐을 때 이동 가능한지 판별하는 기능이 제대로 동작하는지 테스트")
    @Test
    void bridgePossibleMoveTest() {
        boolean ret;
        ret = bridge.possibleMove("U");
        if (!ret) {
            ret = bridge.possibleMove("D");
        }
        assertThat(ret).isEqualTo(true);
    }

    @DisplayName("toString이 제대로 동작하는지 테스트")
    @Test
    void bridgeToStringTest() {
        for (int i = 0; i < 3; i++) {
            bridgeGame.move("U");
            if (!bridge.getCorrect()) {
                bridgeGame.move("D");
            }
        }
        assertThat(bridge.toString()).containsAnyOf(
                "[   |   |   ]",
                "[ O |   |   ]",
                "[   | O |   ]",
                "[   |   | O ]",
                "[ O | O |   ]",
                "[   | O | O ]",
                "[ O | O | O ]"
        );
    }
 }
