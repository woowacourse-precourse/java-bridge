package bridge.gamebridge;

import static bridge.command.util.MoveTestUtils.convertStringListToMoveList;
import static bridge.config.ExceptionMessage.ERROR;
import static bridge.result.GameStatus.FAIL;
import static bridge.result.GameStatus.PROGRESS;
import static bridge.result.GameStatus.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Bridge;
import bridge.command.Move;
import bridge.result.Result;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }

    @DisplayName("정답 브릿지는 생성된 상태로 한번더 생성하면 예외가 발생한다.")
    @Test
    void generateAnswerBridgeOneMoreTime() {
        BridgeContainer bridgeContainer = new BridgeContainer();
        bridgeContainer.generateAnswerBridge(new Bridge(List.of("U")));
        assertThatThrownBy(() -> bridgeContainer.generateAnswerBridge(new Bridge(List.of("D", "U"))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }


    private void insertMovesForTest(List<String> inputMoves, BridgeContainer bridgeContainer) {
        List<Move> moves = convertStringListToMoveList(inputMoves);
        for (Move move : moves) {
            bridgeContainer.insertMove(move);
        }
    }
}
