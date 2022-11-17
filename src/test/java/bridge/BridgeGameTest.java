package bridge;

import static bridge.constant.BridgeMatch.CAN_MOVE;
import static bridge.constant.BridgeMatch.CAN_NOT_MOVE;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.BridgeMatch;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {

    @ParameterizedTest
    @ValueSource(ints = {0})
    void moveByU(int count) {
        // given
        List<String> bridge = List.of("U", "D", "D");
        String player = "U";
        BridgeGame bridgeGame = new BridgeGame();

        // when
        BridgeMatch result = bridgeGame.move(bridge, player, count);

        // then
        assertThat(result).isEqualTo(CAN_MOVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    void moveByD(int count) {
        // given
        List<String> bridge = List.of("U", "D", "D");
        String player = "D";
        BridgeGame bridgeGame = new BridgeGame();

        // when
        BridgeMatch result = bridgeGame.move(bridge, player, count);

        // then
        assertThat(result).isEqualTo(CAN_MOVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void compareByNotMatch(int count) {
        // given
        List<String> bridge = List.of("U", "D", "D");
        String player = "D";
        BridgeGame bridgeGame = new BridgeGame();

        // when
        BridgeMatch result = bridgeGame.move(bridge, player, count);

        // then
        assertThat(result).isEqualTo(CAN_NOT_MOVE);
    }
}