package bridge;

import bridge.Enum.CrossResult;
import bridge.Enum.GameStatus;
import bridge.Model.BridgeGame;
import bridge.Model.WrappingType.ChoiceDirection;
import bridge.Model.WrappingType.ChoiceDirections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

public class BridgeGameTest {
    private List<String> bridge = List.of("U", "U", "D");

    @DisplayName("checkGameStatus 메소드 테스트")
    @ParameterizedTest(name = "[{index}] {2} Test")
    @MethodSource("generateData")
    void checkGameStatusTest(List<ChoiceDirection> choiceDirections, List<CrossResult> crossResults, GameStatus result) {
        BridgeGame bridgeGame = new BridgeGame(bridge, choiceDirections, crossResults);
        GameStatus actual = bridgeGame.checkGameStatus();

        assertThat(actual).isEqualTo(result);
    }

    static Stream<Arguments> generateData() {
        List<List<ChoiceDirection>> choiceDirections = List.of(
                ChoiceDirections.of(List.of("U", "U", "D")),
                ChoiceDirections.of(List.of("U", "D")),
                ChoiceDirections.of(List.of("D"))
        );

        List<List<CrossResult>> crossResults = List.of(
                List.of(CrossResult.SUCCESS, CrossResult.SUCCESS, CrossResult.SUCCESS),
                List.of(CrossResult.SUCCESS, CrossResult.FAIL),
                List.of(CrossResult.FAIL)
        );

        List<GameStatus> gameStatuses = List.of(
                GameStatus.SUCCESS,
                GameStatus.FAIL,
                GameStatus.FAIL
        );

        return Stream.of(
                Arguments.of(choiceDirections.get(0), crossResults.get(0), gameStatuses.get(0)),
                Arguments.of(choiceDirections.get(1), crossResults.get(1), gameStatuses.get(1)),
                Arguments.of(choiceDirections.get(2), crossResults.get(2), gameStatuses.get(2))
        );
    }
}
