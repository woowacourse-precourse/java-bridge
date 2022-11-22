package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 사용자_다리_건너기_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        assertThat(bridgeGame.getUserPath()).isEqualTo(List.of("U", "U", "D", "U"));
    }

    @Test
    void 현재_위치_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.getBridgePosition()).isEqualTo(1);
    }

    static Stream<Arguments> setParametersForClearCheck() {
        return Stream.of(
                Arguments.arguments(new ArrayList<String>(List.of("U", "U", "U")), true),
                Arguments.arguments(new ArrayList<String>(List.of("U", "U", "U", "U")), false),
                Arguments.arguments(new ArrayList<String>(List.of("U", "U", "D")), false));
    }

    @MethodSource("setParametersForClearCheck")
    @ParameterizedTest(name = "클리어 여부 테스트{index}")
    void 게임_클리어_여부_테스트(List<String> bridge, boolean result) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.checkGameClear(new Bridge(bridge))).isEqualTo(result);
    }
}