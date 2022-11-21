package bridge;

import bridge.config.Direction;
import bridge.config.GameStatus;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @DisplayName("성공적으로 이동했을 때")
    @ParameterizedTest
    @MethodSource("generateWinMoves")
    public void gameWinTest(List<String> bridgeInput, List<String> moveDirections) {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(bridgeInput));
        moveDirections.forEach(d -> bridgeGame.move(Direction.of(d)));
        assertThat(bridgeGame.getStatus()).isEqualTo(GameStatus.WIN);
    }


    private static Stream<Arguments> generateWinMoves() {
        return Stream.of(
                Arguments.of(Arrays.asList("U", "U", "D", "U"), Arrays.asList("U", "U", "D", "U")),
                Arguments.of(Arrays.asList("D", "U", "D", "D", "U"), Arrays.asList("D", "U", "D", "D", "U")),
                Arguments.of(Arrays.asList("U", "U", "U"), Arrays.asList("U", "U", "U"))
        );
    }

}
