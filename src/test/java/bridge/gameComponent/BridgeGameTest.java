package bridge.gameComponent;

import bridge.util.MoveResult;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class BridgeGameTest {
    @Test
    void 브릿지게임_생성_Null입력_테스트() {
        //given
        Bridge bridge = null;
        //when
        Throwable throwable = catchThrowable(() -> {
            new BridgeGame(bridge);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 브릿지게임_정상_생성() {
        //given
        Bridge bridge = Bridge.of(List.of("U","D"));
        //when
        BridgeGame bridgeGame = new BridgeGame(bridge);
        //then
        assertThat(bridgeGame.getLastStep())
                .isEqualTo(1);
    }
    @Test
    void move테스트_다리길이를_초과한_경우() {
        //given
        Bridge bridge = Bridge.of(List.of("U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.moveForward(MoveResult.CORRECT, "U");
        //when
        Throwable throwable = catchThrowable(() -> {
            bridgeGame.moveForward(MoveResult.CORRECT, "U");
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalStateException.class);
    }
    @Test
    void 정상_move테스트() {
        //given
        Bridge bridge = Bridge.of(List.of("U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        //when
        bridgeGame.moveForward(MoveResult.CORRECT, "U");
        //then
        assertThat(bridgeGame.getBridgeIndex())
                .isEqualTo(0);
    }

    @Test
    void retryTest_게임_성공_예외() {
        //given
        Bridge bridge = Bridge.of(List.of("U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.moveForward(MoveResult.CORRECT, "U");
        //when
        Throwable throwable = catchThrowable(() -> {
            bridgeGame.retry();
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void retryTest_정상() {
        //given
        Bridge bridge = Bridge.of(List.of("U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.moveForward(MoveResult.WRONG,"D");
        //when
        bridgeGame.retry();
        //then
        assertThat(bridgeGame.getNumberOfTrials())
                .isEqualTo(2);
        assertThat(bridgeGame.getBridgeIndex())
                .isEqualTo(-1);
    }

    @Test
    void isSuccess_true_테스트() {
        //given
        Bridge bridge = Bridge.of(List.of("U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.moveForward(MoveResult.CORRECT, "U");
        //when
        boolean isSuccess = bridgeGame.isSuccess();
        //then
        assertThat(isSuccess)
                .isTrue();
    }
    @Test
    void isSuccess_false_테스트() {
        //given
        Bridge bridge = Bridge.of(List.of("U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        //when
        boolean isSuccess = bridgeGame.isSuccess();
        //then
        assertThat(isSuccess)
                .isFalse();
    }

    @Test
    void recordMapTest() {
        //given
        Bridge bridge = Bridge.of(List.of("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        MoveResult moveResult1 = MoveResult.CORRECT;
        MoveResult moveResult2 = MoveResult.WRONG;
        //when
        bridgeGame.moveForward(moveResult1, "U");
        bridgeGame.moveForward(moveResult2, "U");
        char[][] map = bridgeGame.getCurrentBridge(moveResult2);
        //then
        assertThat(map)
                .contains(new char[] {'O','X','\u0000'}, Index.atIndex(0))
                .contains(new char[] {' ', ' ', '\u0000'}, Index.atIndex(1));
    }
    @Test
    void recordMapTest_최초실패() {
        //given
        Bridge bridge = Bridge.of(List.of("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        MoveResult moveResult = MoveResult.WRONG;
        //when
        bridgeGame.moveForward(moveResult, "D");
        char[][] map = bridgeGame.getCurrentBridge(moveResult);

        //then
        assertThat(map)
                .contains(new char[] {' ','\u0000','\u0000'}, Index.atIndex(0))
                .contains(new char[] {'X', '\u0000', '\u0000'}, Index.atIndex(1));
    }
    @Test
    void isPossibleMoveTest_불가능한_경우() {
        //given
        Bridge bridge = Bridge.of(List.of("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String userMove = "D";
        //when
        MoveResult moveResult = bridgeGame.isCorrectMove(userMove);
        //then
        assertThat(moveResult)
                .isEqualTo(MoveResult.WRONG);
    }
    @Test
    void isPossibleMoveTest_가능한_경우() {
        //given
        Bridge bridge = Bridge.of(List.of("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String userMove = "U";
        //when
        MoveResult moveResult = bridgeGame.isCorrectMove(userMove);
        //then
        assertThat(moveResult)
                .isEqualTo(MoveResult.CORRECT);
    }
}
