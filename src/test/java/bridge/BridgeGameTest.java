package bridge;

import bridge.input.ValidationType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeGameTest {

    @DisplayName("입력 값에 따른 move 메서드 테스트")
    @MethodSource("provideParametersForMove")
    @ParameterizedTest
    void BridgeGame_move_Method(List<String> bridge, int countOfMove, String moveBlock, boolean result) {
        BridgeGame bridgeGame = new BridgeGame();
        boolean canMove = bridgeGame.move(bridge, countOfMove, moveBlock);
        assertThat(canMove).isEqualTo(result);
    }

    @DisplayName("입력 값에 따른 move 메서드 테스트")
    @MethodSource("provideParametersForRetry")
    @ParameterizedTest
    void BridgeGame_retry_method(String input, boolean result) {
        BridgeGame bridgeGame = new BridgeGame();
        boolean isRetry = bridgeGame.retry(input);
        assertThat(isRetry).isEqualTo(result);
    }

    private static Stream<Arguments> provideParametersForMove() {
        return Stream.of(
                Arguments.of(List.of("U", "D", "D", "U"), 2, "U", false),
                Arguments.of( List.of("U", "D", "D", "U"), 2, "D", true),
                Arguments.of( List.of("U", "U", "U"), 1, "U", true)
        );
    }

    private static Stream<Arguments> provideParametersForRetry() {
        return Stream.of(
                Arguments.of("R", true),
                Arguments.of( "Q", false)
        );
    }
}
