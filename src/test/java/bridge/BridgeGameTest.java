package bridge;

import bridge.Enum.CrossResult;
import bridge.Enum.GameStatus;
import bridge.Model.BridgeGame;
import bridge.Model.WrappingType.ChoiceDirection;
import bridge.Model.WrappingType.ChoiceDirections;
import bridge.Model.WrappingType.CrossResults;
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
    void checkGameStatusTest(List<ChoiceDirection> choiceDirections, List<CrossResult> crossResults, GameStatus result){
        BridgeGame bridgeGame = new BridgeGame(bridge, choiceDirections, crossResults);
        GameStatus actual = bridgeGame.checkGameStatus();

        assertThat(actual).isEqualTo(result);
    }

    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of(ChoiceDirections.of(List.of("U", "U", "D")), List.of(CrossResult.SUCCESS, CrossResult.SUCCESS, CrossResult.SUCCESS), GameStatus.SUCCESS),
                Arguments.of(ChoiceDirections.of(List.of("U", "D")), List.of(CrossResult.SUCCESS, CrossResult.FAIL), GameStatus.FAIL),
                Arguments.of(ChoiceDirections.of(List.of("D")), List.of(CrossResult.FAIL), GameStatus.FAIL)
        );
    }
}
