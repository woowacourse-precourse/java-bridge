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

    @DisplayName("게임을 진행하며 건널 수 있는 다리인 경우 true, 없으면 false를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateMovingData")
    void createFailMoveInBridgeGame(String moving, boolean passedFlag) {
        // given
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "U", "U")), new User());

        // when, then
        assertThat(bridgeGame.move(moving)).isEqualTo(passedFlag);
    }

    static Stream<Arguments> generateMovingData() {
        return Stream.of(
                Arguments.of("U", true),
                Arguments.of("D", false)
        );
    }

    @DisplayName("게임을 진행하며 다리를 건너는 경우, 다리 상태가 업데이트 된다.")
    @ParameterizedTest
    @MethodSource("generateMovingAndResultData")
    void createBridgeStateInBridgeGame(String moving, String upperResult, String lowerResult) {
        // given
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "U", "U")), new User());

        // when
        bridgeGame.move(moving);

        // then
        assertThat(bridgeGame.getBridgeState().getUpperBridge().get(0)).isEqualTo(upperResult);
        assertThat(bridgeGame.getBridgeState().getLowerBridge().get(0)).isEqualTo(lowerResult);
    }

    static Stream<Arguments> generateMovingAndResultData() {
        return Stream.of(
                Arguments.of("U", "O", " "),
                Arguments.of("D", " ", "X")
        );
    }

    @DisplayName("게임을 재시작하는 경우, 사용자의 위치와 다리 상태가 초기화된다.")
    @Test
    void resetUserPositionAndBridgeStateInBridgeGame() {
        // given
        User user = new User();
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "U", "U")), user);

        // when
        bridgeGame.move("D");
        bridgeGame.retry();

        // then
        assertThat(user.getPosition()).isEqualTo(0);
        assertThat(bridgeGame.getBridgeState().getLowerBridge().size()).isEqualTo(0);
        assertThat(bridgeGame.getBridgeState().getUpperBridge().size()).isEqualTo(0);
    }

    @DisplayName("다리를 통과한 경우 게임 종료 조건이 충족되고, 통과하지 못한경우 종료 조건을 만족하지 않는다.")
    @ParameterizedTest
    @MethodSource("generateBridgeAndMovingData")
    void getGameEndSuccessCondition(List<String> bridge, List<String> movings, boolean endFlag) {
        // given
        BridgeGame bridgeGame = new BridgeGame(new Bridge(bridge), new User());

        // when
        movings.stream().forEach(moving -> bridgeGame.move(moving));

        // then
        assertThat(bridgeGame.canContinue()).isEqualTo(endFlag);
    }

    static Stream<Arguments> generateBridgeAndMovingData() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "U"), List.of("U", "U", "U"), false),
                Arguments.of(List.of("U", "U", "U"), List.of("U", "U", "D"), true)
        );
    }
}