package bridge.gmaebridge;

import static bridge.option.util.MoveTestUtils.convertStringListToMoveList;
import static bridge.result.GameStatus.FAIL;
import static bridge.result.GameStatus.PROGRESS;
import static bridge.result.GameStatus.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Bridge;
import bridge.gamebridge.BridgeContainer;
import bridge.option.Move;
import bridge.result.Result;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BridgeContainerTest {

    @DisplayName("사용자 입력 결과 참인 테스트")
    @Test
    void checkInsertedMoveTest() {
        BridgeContainer bridgeContainer = new BridgeContainer();
        bridgeContainer.generateAnswerBridge(new Bridge(List.of("U", "D", "U", "U", "D")));
        insertMovesForTest(List.of("U", "D"), bridgeContainer);

        Result result = bridgeContainer.insertMove(new Move("U"));

        assertThat(result.getGameStatus()).isEqualTo(PROGRESS);
    }

    @DisplayName("사용자 입력 결과 거짓인 테스트")
    @Test
    void checkInsertedWrongMoveTest() {
        BridgeContainer bridgeContainer = new BridgeContainer();
        bridgeContainer.generateAnswerBridge(new Bridge(List.of("U", "D", "U", "U", "D")));
        insertMovesForTest(List.of("U", "D"), bridgeContainer);

        Result result = bridgeContainer.insertMove(new Move("D"));

        assertThat(result.getGameStatus()).isEqualTo(FAIL);
    }

    @DisplayName("사용자가 게임을 클리어 했을 때 테스트")
    @Test
    void checkInsertSuccessBridge() {
        BridgeContainer bridgeContainer = new BridgeContainer();
        bridgeContainer.generateAnswerBridge(new Bridge(List.of("U", "D", "U", "U", "D")));
        insertMovesForTest(List.of("U", "D", "U", "U"), bridgeContainer);

        Result result = bridgeContainer.insertMove(new Move("D"));

        assertThat(result.getGameStatus()).isEqualTo(SUCCESS);
    }

    @DisplayName("정답 브릿지를 생성하지 않고 입력하면 예외가 발생한다.")
    @Test
    void insertMoveBeforeGenerateAnswerBridge() {
        BridgeContainer bridgeContainer = new BridgeContainer();
        assertThatThrownBy(() -> bridgeContainer.insertMove(new Move("U")))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateTestMoveInput() {
        return Stream.of(
            Arguments.of(List.of("U")),
            Arguments.of(List.of("U", "D", "D", "U")),
            Arguments.of(List.of("D", "U", "D", "U"))
        );
    }

    private void insertMovesForTest(List<String> inputMoves, BridgeContainer bridgeContainer) {
        List<Move> moves = convertStringListToMoveList(inputMoves);
        for (Move move : moves) {
            bridgeContainer.insertMove(move);
        }
    }
}
