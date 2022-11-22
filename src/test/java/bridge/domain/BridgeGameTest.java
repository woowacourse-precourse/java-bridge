package bridge.domain;

import bridge.domain.type.RoundResultType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private static final String CLEAR_DESC_SUCCESS = "게임 성공 여부: 성공";
    private static final String CLEAR_DESC_FAIL = "게임 성공 여부: 실패";
    private BridgeGame bridgeGame;

    static Stream<Arguments> getResourceForMove() {
        return Stream.of(
                Arguments.of(List.of("U", "D"), RoundResultType.PLAYING),
                Arguments.of(List.of("U", "U"), RoundResultType.FAIL),
                Arguments.of(List.of("D"), RoundResultType.FAIL),
                Arguments.of(List.of("U", "D", "D", "U"), RoundResultType.CLEAR)
        );
    }

    static Stream<Arguments> getResourceClearDescription() {
        return Stream.of(
                Arguments.of(List.of("U", "D", "D", "D"), CLEAR_DESC_FAIL),
                Arguments.of(List.of("U", "D", "D", "U"), CLEAR_DESC_SUCCESS)
        );
    }

    static Stream<Arguments> getResourceTryCountDescription() {
        return Stream.of(
                Arguments.of(0, "0"),
                Arguments.of(1, "1"),
                Arguments.of(2, "2")
        );
    }

    @BeforeEach
    private void setUp() {
        Bridge bridge = Bridge.from(List.of("U", "D", "D", "U"));
        BridgeWalker bridgeWalker = new BridgeWalker(new MoveRecord(), bridge);
        this.bridgeGame = new BridgeGame(bridgeWalker);
    }

    private RoundResultType move(String moveCommand) {
        return bridgeGame.move(moveCommand);
    }

    @ParameterizedTest
    @MethodSource("getResourceForMove")
    @DisplayName("move에 따른 roundResult가 올바르게 나오는지 검사")
    public void TestMoveClear(List<String> moveCommands, RoundResultType roundResultType) {
        int index;
        for (index = 0; index < moveCommands.size() - 1; index++) {
            move(moveCommands.get(index));
        }
        assertThat(move(moveCommands.get(index))).isEqualTo(roundResultType);
    }

    @ParameterizedTest
    @MethodSource("getResourceClearDescription")
    @DisplayName("move에 따른 ClearDescription이 올바르게 나오는지 검사")
    public void TestGetClearDescription(List<String> moveCommands, String result) {
        for (int index = 0; index < moveCommands.size(); index++) {
            move(moveCommands.get(index));
        }
        assertThat(bridgeGame.getClearDescription()).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("getResourceTryCountDescription")
    @DisplayName("retry() 횟수에 따른 gameTryCount가 올바르게 나오는지 검사")
    public void TestGetTryCountDescription(int countOfRetry, String result) {
        for (int count = 1; count <= countOfRetry; count++) {
            bridgeGame.retry();
        }
        assertThat(bridgeGame.getGameTryCountDescription()).contains(result);
    }
}
