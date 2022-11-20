package bridge.domain;

import static bridge.command.util.MoveTestUtils.convertStringListToMoveList;
import static bridge.result.GameStatus.FAIL;
import static bridge.result.GameStatus.PROGRESS;
import static bridge.result.GameStatus.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeNumberGenerator;
import bridge.bridgemaker.BridgeMaker;
import bridge.bridgemaker.TestBridgeNumberGenerator;
import bridge.command.Move;
import bridge.result.Result;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeServiceTest {

    @DisplayName("테스트 숫자 생성기 테스트")
    @Test
    void generateBridgeNumbersTest() {
        BridgeNumberGenerator generator = new TestBridgeNumberGenerator(newArrayList(1, 0, 1, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> answer = List.of("U", "D", "U", "U", "D");

        List<String> squares = bridgeMaker.makeBridge(5);
        assertThat(answer).isEqualTo(squares);
    }

    @DisplayName("건널 수 있는 다리에 움직임")
    @Test
    void MoveToCrossAbleBridge() {
        BridgeNumberGenerator generator = new TestBridgeNumberGenerator(newArrayList(1, 0, 1, 1, 0));
        BridgeService bridgeService = new BridgeService(generator);
        bridgeService.generateBridge(5);

        insertMove(List.of("U", "D", "U"), bridgeService);
        Result result = bridgeService.insertMove(new Move("U"));

        assertThat(result.getGameStatus()).isEqualTo(PROGRESS);
    }

    @DisplayName("건널 수 없는 다리에 움직임 테스트")
    @Test
    void MoveToImpassableBridge() {
        BridgeNumberGenerator generator = new TestBridgeNumberGenerator(newArrayList(1, 0, 1, 1, 0));
        BridgeService bridgeService = new BridgeService(generator);
        bridgeService.generateBridge(5);

        insertMove(List.of("U", "D", "U", "U"), bridgeService);
        Result result = bridgeService.insertMove(new Move("U"));

        assertThat(result.getGameStatus()).isEqualTo(FAIL);
    }

    @DisplayName("게임 클리어 테스트")
    @Test
    void MoveToGameClearBridge() {
        BridgeNumberGenerator generator = new TestBridgeNumberGenerator(newArrayList(1, 0, 1, 1, 0));
        BridgeService bridgeService = new BridgeService(generator);
        bridgeService.generateBridge(5);

        insertMove(List.of("U", "D", "U", "U"), bridgeService);
        Result result = bridgeService.insertMove(new Move("D"));

        assertThat(result.getGameStatus()).isEqualTo(SUCCESS);
    }

    private void insertMove(List<String> inputMoves, BridgeService bridgeService) {
        List<Move> moves = convertStringListToMoveList(inputMoves);
        for (Move move : moves) {
            bridgeService.insertMove(move);
        }
    }
}
