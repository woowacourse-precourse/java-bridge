package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Game;
import bridge.domain.MoveIndicator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @ParameterizedTest
    @MethodSource("moveParametersProvider")
    void moveTest(String userDirection, String accessibleDirection, List<Bridge> bridges) {
        List<String> expected = List.of("[ O ]", "[   ]");
        assertThat(bridgeGame.move(userDirection, accessibleDirection, bridges))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("retryParametersProvider")
    void retryTest(Game game, String userResponse) {
        Boolean expected = true;
        assertThat(bridgeGame.retry(game, userResponse))
                .isEqualTo(expected);
    }

    static Stream<Arguments> moveParametersProvider() {
        return Stream.of(
                arguments("U", "U", List.of(new Bridge(MoveIndicator.UP),
                        new Bridge(MoveIndicator.DOWN))));
    }

    static Stream<Arguments> retryParametersProvider() {
        return Stream.of(
                arguments(new Game(3), "R"));
    }

}
