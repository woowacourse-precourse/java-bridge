package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    static Stream<Bridge> bridgeDoneParameter() {
        return Stream.of(
                new Bridge(List.of("U", "U", "U")),
                new Bridge(List.of("U", "U", "D")));
    }

    static Stream<Bridge> bridgeWinParameter() {
        return Stream.of(
                new Bridge(List.of("U", "U", "U")),
                new Bridge(List.of("U", "U", "U", "U")),
                new Bridge(List.of("U", "U", "U", "U", "U")),
                new Bridge(List.of("U", "U", "U", "U", "U")));
    }


    @DisplayName("다리 건너기 게임이 끝났을 때 반환 값이 올바른지 확인")
    @ParameterizedTest
    @MethodSource("bridgeDoneParameter")
    void isDoneWithDone(final Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge.getBridgeSize());
        for (int i = 0; i < bridge.getBridgeSize(); ++i) {
            bridgeGame.move("U");
        }
        assertThat(bridgeGame.isDone(bridge)).isEqualTo(true);
    }

    @DisplayName("다리 건너기 게임이 끝나지 않았을 때 반환 값이 올바른지 확인")
    @ParameterizedTest
    @MethodSource("bridgeDoneParameter")
    void isDoneWithNotDone(final Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge.getBridgeSize());
        for (int i = 0; i < bridge.getBridgeSize() - 1; ++i) {
            bridgeGame.move("U");
        }
        assertThat(bridgeGame.isDone(bridge)).isEqualTo(false);
    }

    @DisplayName("다리 건너기 게임 성공 했을 때 반환 값이 올바른지 확인")
    @ParameterizedTest
    @MethodSource("bridgeWinParameter")
    void isWinWithWin(final Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge.getBridgeSize());
        for (int i = 0; i < bridge.getBridgeSize(); ++i) {
            bridgeGame.move("U");
        }
        assertThat(bridgeGame.isWin(bridge)).isEqualTo(true);
    }

    @DisplayName("다리 건너기 게임 실패 했을 때 반환 값이 올바른지 확인")
    @ParameterizedTest
    @MethodSource("bridgeWinParameter")
    void isWinWithNotWin(final Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge.getBridgeSize());
        for (int i = 0; i < bridge.getBridgeSize(); ++i) {
            bridgeGame.move("D");
        }
        assertThat(bridgeGame.isWin(bridge)).isEqualTo(false);
    }


    @DisplayName("유효한 인덱스가 들어 왔을 때 결과를 정확히 반환하는지 확인")
    @Test
    void bridgeGameAccessWithValidIndex() {
        List<String> expected = new ArrayList<>(List.of("U", "U", "U"));
        BridgeGame bridgeGame = new BridgeGame(expected.size());
        for (int i = 0; i < expected.size(); ++i) {
            bridgeGame.move("U");
            assertThat(bridgeGame.getUserAnswerByIndex(i)).isEqualTo(expected.get(i));
        }
    }

    @DisplayName("유효하지 않은 인덱스가 들어 왔을 때 Exception 을 던지는지 확인")
    @ParameterizedTest(name = "[{index}] 번째 테스트 인자 : {0}")
    @ValueSource(ints = {3, 4, 5})
    void bridgeGameAccessWithInvalidIndex(final int invalidIndex) {
        List<String> expected = new ArrayList<>(List.of("U", "U", "U"));
        BridgeGame bridgeGame = new BridgeGame(expected.size());
        assertThatThrownBy(() -> bridgeGame.getUserAnswerByIndex(invalidIndex))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

}