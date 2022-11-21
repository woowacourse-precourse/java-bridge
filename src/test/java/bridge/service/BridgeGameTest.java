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
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U")), new User());
        boolean expectedFlag = true;

        // when
        List<String> movings = List.of("U", "D", "U");

        // then
        movings.forEach(moving -> assertThat(bridgeGame.move(moving)).isEqualTo(expectedFlag));
    }

    @DisplayName("게임을 진행하며 건널 수 있는 다리인 경우 false를 반환한다.")
    @Test
    void createFailMoveInBridgeGame() {
        // given
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "U", "U")), new User());
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
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "U", "U")), new User());

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

    @DisplayName("다리를 통과한 경우, 게임 종료 조건이 충족된다.")
    @Test
    void getGameEndSuccessCondition() {
        // given
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "U", "U")), new User());

        // when
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");

        // then
        assertThat(bridgeGame.canContinue()).isEqualTo(false);
    }

    @DisplayName("다리를 통과하지 못한경우, 게임 종료 조건을 만족하지 않는다.")
    @Test
    void getGameEndFailCondition() {
        // given
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "U", "U")), new User());

        // when
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");

        // then
        assertThat(bridgeGame.canContinue()).isEqualTo(true);
    }
}