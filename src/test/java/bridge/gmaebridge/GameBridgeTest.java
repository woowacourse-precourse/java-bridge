package bridge.gmaebridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.gamebridge.GameBridge;
import bridge.option.Move;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameBridgeTest {

    @DisplayName("플레이어 현재 다리에 추가 무브 테스트")
    @MethodSource("generateTestMoveInput")
    @ParameterizedTest
    void insertMoveInPlayerBridgeTest(List<String> inputMoves) {
        GameBridge gameBridge = new GameBridge();
        insertMovesForTest(inputMoves, gameBridge);
        Bridge answerBridge = new Bridge(inputMoves);
        Bridge bridge = gameBridge.getPlayerBridge().getBridge();
        assertThat(bridge.getSquares()).isEqualTo(answerBridge.getSquares());
    }

    private static Stream<Arguments> generateTestMoveInput() {
        return Stream.of(
            Arguments.of(List.of("U")),
            Arguments.of(List.of("U", "D", "D", "U")),
            Arguments.of(List.of("D", "U", "D", "U"))
        );
    }

    private void insertMovesForTest(List<String> inputMoves, GameBridge gameBridge) {
        List<Move> moves = convertStringListToMoveList(inputMoves);
        for (Move move : moves) {
            gameBridge.insertMoveInPlayerBridge(move);
        }
    }

    private List<Move> convertStringListToMoveList(List<String> inputMoves) {
        List<Move> moves = new ArrayList<>();
        for (String inputMove : inputMoves) {
            moves.add(new Move(inputMove));
        }
        return moves;
    }
}
