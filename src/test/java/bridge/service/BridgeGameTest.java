package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.User;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


class BridgeGameTest {

    @DisplayName("게임을 진행하며 건널 수 있는 다리인 경우 true를 반환한다.")
    @Test
    void createSuccessMoveInBridgeGame() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        User user = new User();
        BridgeGame bridgeGame = new BridgeGame(bridge, user);
        boolean expectedFlag = true;

        // when
        List<String> movings = List.of("U", "D", "U");

        //then
        movings.forEach(moving -> assertThat(bridgeGame.move(moving)).isEqualTo(expectedFlag));
    }

    @DisplayName("게임을 진행하며 건널 수 있는 다리인 경우 false를 반환한다.")
    @Test
    void createFailMoveInBridgeGame() {
        // given
        Bridge bridge = new Bridge(List.of("U", "U", "U"));
        User user = new User();
        BridgeGame bridgeGame = new BridgeGame(bridge, user);
        boolean expectedFlag = false;

        // when
        List<String> movings = List.of("D", "D", "D");

        //then
        movings.forEach(moving -> assertThat(bridgeGame.move(moving)).isEqualTo(expectedFlag));
    }

    @DisplayName("게임을 진행하며 다리를 건너는 경우, 다리 상태가 업데이트 된다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void createBridgeStateInBridgeGame(String moving, String upperResult, String lowerResult) {
        // given
        Bridge bridge = new Bridge(List.of("U", "U", "U"));
        User user = new User();
        BridgeGame bridgeGame = new BridgeGame(bridge, user);

        // when
        bridgeGame.move(moving);

        // then
        assertThat(bridgeGame.getBridgeState().getUpperBridge().get(0)).isEqualTo(upperResult);
        assertThat(bridgeGame.getBridgeState().getLowerBridge().get(0)).isEqualTo(lowerResult);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("U", "O", " "),
                Arguments.of("D", " ", "X")
        );
    }
}