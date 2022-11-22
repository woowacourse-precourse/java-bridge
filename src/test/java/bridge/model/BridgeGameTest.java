package bridge.model;

import bridge.TestNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static bridge.model.BridgePosition.BRIDGE_POSITION_UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("BridgeGame를 테스트한다.")
class BridgeGameTest {

    private static BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = BridgeGame.of(3, TestNumberGenerator.from(List.of(1, 0, 0)));
    }

    @DisplayName("다음 위치와 사용자의 입력이 주어지면 다음 위치와 비교해서, 움직가능 여부를 판단한다.")
    @Test
    void judgeMoveIfMovable() {
        assertAll(
                () -> assertThat(
                        bridgeGame.move(0, BRIDGE_POSITION_UP.getCommand())).isEqualTo(List.of("O", " ")
                ),
                () -> assertThat(
                        bridgeGame.move(1, BRIDGE_POSITION_UP.getCommand())).isEqualTo(List.of("X", " ")
                ),
                () -> assertThat(
                        bridgeGame.move(2, BRIDGE_POSITION_UP.getCommand())).isEqualTo(List.of("X", " ")
                )
        );
    }

    @DisplayName("retry 명령어인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"R, true", "Q, false"})
    void returnTrueWhenCommandIsR(String command, boolean result) {
        assertThat(bridgeGame.retry(command)).isEqualTo(result);
    }

    @DisplayName("성공적으로 움직였는지 확인한다.")
    @ParameterizedTest
    @MethodSource("initSuccessMethodTest")
    void returnTrueIfContainsO(final List<String> moveResult, final boolean result) {
        assertThat(bridgeGame.isSuccess(moveResult)).isEqualTo(result);
    }

    private static Stream<Arguments> initSuccessMethodTest() {
        return Stream.of(
                Arguments.of(List.of("O", " "), true),
                Arguments.of(List.of(" ", "O"), true),
                Arguments.of(List.of("X", " "), false),
                Arguments.of(List.of(" ", "X"), false)
        );
    }
}