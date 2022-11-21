package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @DisplayName("이동에 성공했으면 true를 반환한다")
    @Test
    void moveSuccess() {
        Bridge bridge = new Bridge(List.of("D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        boolean move = bridgeGame.move("D");

        assertThat(move).isEqualTo(true);
    }

    @DisplayName("이동에 실패했으면 false를 반환한다")
    @Test
    void moveFail() {
        Bridge bridge = new Bridge(List.of("D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        boolean move = bridgeGame.move("U");

        assertThat(move).isEqualTo(false);
    }

    @DisplayName("위쪽 다리의 결과를 가져온다")
    @Test
    void getMovementsInUpBridge() {
        Bridge bridge = new Bridge(List.of("D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.move("U");
        bridgeGame.move("U");

        assertThat(bridgeGame.getUpBridgeResult()).isEqualTo(List.of(" X ", " O "));
    }

    @DisplayName("아래쪽 다리의 결과를 가져온다")
    @Test
    void getMovementsInDownBridge() {
        Bridge bridge = new Bridge(List.of("D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.move("D");
        bridgeGame.move("D");

        assertThat(bridgeGame.getDownBridgeResult()).isEqualTo(List.of(" O ", " X "));
    }

    @DisplayName("마지막 순서면 true를 반환한다")
    @Test
    void isFinished() {
        Bridge bridge = new Bridge(List.of("D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.move("D");
        bridgeGame.move("D");
        bridgeGame.move("D");

        assertThat(bridgeGame.isFinished()).isEqualTo(true);
    }

    @DisplayName("마지막 순서가 아니면 false를 반환한다")
    @Test
    void isNotFinished() {
        Bridge bridge = new Bridge(List.of("D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.move("D");
        bridgeGame.move("D");

        assertThat(bridgeGame.isFinished()).isEqualTo(false);
    }
}
