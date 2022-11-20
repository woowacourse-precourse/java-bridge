package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameResultTest {

    @Test
    void create() {
        List<Boolean> actualBooleans = List.of(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE);
        Bridge actualBridge = new Bridge(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP));
        BridgeGameResult actual = new BridgeGameResult(actualBridge, actualBooleans);
        Bridge expectedBridge = new Bridge(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP));
        List<Boolean> expectedBooleans = List.of(true, false, true);
        BridgeGameResult expected = new BridgeGameResult(expectedBridge, expectedBooleans);

        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> provideForIsFail() {
        return Stream.of(
                Arguments.of(List.of(true, true, true), false),
                Arguments.of(List.of(true, true, false), true),
                Arguments.of(List.of(true, false, true), true)
        );
    }

    @ParameterizedTest(name = "게임 결과가 실패인지 반환한다.")
    @MethodSource("provideForIsFail")
    void isFail(List<Boolean> playerMoveResult, boolean expected) {
        Bridge bridge = new Bridge(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP));
        BridgeGameResult bridgeGameResult = new BridgeGameResult(bridge, playerMoveResult);

        assertThat(bridgeGameResult.isFail()).isEqualTo(expected);
    }

    public static Stream<Arguments> provideForIsSuccess() {
        return Stream.of(
                Arguments.of(List.of(true), false),
                Arguments.of(List.of(true, true), false),
                Arguments.of(List.of(true, true, false), false),
                Arguments.of(List.of(true, false, true), false),
                Arguments.of(List.of(true, true, true), true)
        );
    }

    @ParameterizedTest(name = "게임 결과가 성공인지 반환한다.")
    @MethodSource("provideForIsSuccess")
    void isSuccess(List<Boolean> playerMoveResult, boolean expected) {
        Bridge bridge = new Bridge(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP));
        BridgeGameResult bridgeGameResult = new BridgeGameResult(bridge, playerMoveResult);

        assertThat(bridgeGameResult.isSuccess()).isEqualTo(expected);
    }
}
