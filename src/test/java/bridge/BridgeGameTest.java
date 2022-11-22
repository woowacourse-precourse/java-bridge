package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.User;
import bridge.util.BridgeBlock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @DisplayName("이동에 성공했으면 true를 반환한다")
    @Test
    void moveSuccess() {
        User user = new User(new Bridge(List.of("D", "U", "D")));
        BridgeGame bridgeGame = new BridgeGame(user);

        boolean move = bridgeGame.move("D");

        assertThat(move).isEqualTo(true);
    }

    @DisplayName("이동에 실패했으면 false를 반환한다")
    @Test
    void moveFail() {
        User user = new User(new Bridge(List.of("D", "U", "D")));
        BridgeGame bridgeGame = new BridgeGame(user);

        boolean move = bridgeGame.move("U");

        assertThat(move).isEqualTo(false);
    }

    @DisplayName("재시작을 선택하면 시도 횟수가 증가한다")
    @Test
    void getTrialCountByRetry() {
        User user = new User(new Bridge(List.of("D", "U", "D")));
        BridgeGame bridgeGame = new BridgeGame(user);

        bridgeGame.retry("R");

        assertThat(bridgeGame.getTrialCount()).isEqualTo(2);
    }

    @DisplayName("재시작을 선택하지 않으면 시도 횟수가 증가하지 않는다")
    @Test
    void getTrialCountByQuit() {
        User user = new User(new Bridge(List.of("D", "U", "D")));
        BridgeGame bridgeGame = new BridgeGame(user);

        bridgeGame.retry("Q");

        assertThat(bridgeGame.getTrialCount()).isEqualTo(1);
    }

    @DisplayName("위쪽 다리의 결과를 가져온다")
    @Test
    void getMovementsInUpBridge() {
        User user = new User(new Bridge(List.of("D", "U", "D")));
        BridgeGame bridgeGame = new BridgeGame(user);

        bridgeGame.move("U");
        bridgeGame.move("U");

        assertThat(bridgeGame.getUpBridgeMoveResult()).isEqualTo(List.of(BridgeBlock.FAIL_MOVED.getBlock(), BridgeBlock.SUCCESS_MOVED.getBlock()));
    }

    @DisplayName("아래쪽 다리의 결과를 가져온다")
    @Test
    void getMovementsInDownBridge() {
        User user = new User(new Bridge(List.of("D", "U", "D")));
        BridgeGame bridgeGame = new BridgeGame(user);

        bridgeGame.move("D");
        bridgeGame.move("D");

        assertThat(bridgeGame.getDownBridgeResult()).isEqualTo(List.of(BridgeBlock.SUCCESS_MOVED.getBlock(), BridgeBlock.FAIL_MOVED.getBlock()));
    }

    @DisplayName("마지막 순서면 true를 반환한다")
    @Test
    void isFinished() {
        User user = new User(new Bridge(List.of("D", "U", "D")));
        BridgeGame bridgeGame = new BridgeGame(user);

        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");

        assertThat(bridgeGame.isFinished()).isEqualTo(true);
    }

    @DisplayName("마지막 순서가 아니면 false를 반환한다")
    @Test
    void isNotFinished() {
        User user = new User(new Bridge(List.of("D", "U", "D")));
        BridgeGame bridgeGame = new BridgeGame(user);

        bridgeGame.move("D");
        bridgeGame.move("U");

        assertThat(bridgeGame.isFinished()).isEqualTo(false);
    }
}
