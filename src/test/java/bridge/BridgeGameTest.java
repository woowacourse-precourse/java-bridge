package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("사용자의 입력에 따른 다리가 잘 생성되었는지")
    @Test
    void addPlayerBridge_correct() {
        BridgeGame bridgeGame = new BridgeGame(3);
        bridgeGame.addPlayerBridge("U");
        assertThat(bridgeGame.getPlayerBridge().get(0).get(1)).isEqualTo(bridgeGame.getCurrentIsCorrect());
    }

    @DisplayName("재시작 시 플레이어의 위치는 ")
    @Test
    void retry_position() {
        BridgeGame bridgeGame = new BridgeGame(3);
        bridgeGame.addPlayerBridge("U");
        bridgeGame.addPlayerBridge("D");
        bridgeGame.addPlayerBridge("U");
        bridgeGame.retry();
        assertThat(bridgeGame.getPlayerBridgePosition()).isEqualTo(0);
    }

    @DisplayName("재시작 시 시도 수 증가")
    @Test
    void retry_attempts_plus() {
        BridgeGame bridgeGame = new BridgeGame(3);
        bridgeGame.addPlayerBridge("U");
        bridgeGame.addPlayerBridge("D");
        bridgeGame.addPlayerBridge("U");
        bridgeGame.retry();
        assertThat(bridgeGame.getCountAttempts()).isEqualTo(2);
    }
    @DisplayName("플레이어의 입력이 틀렸을때 X반환")
    @Test
    void isCorrect() {
        BridgeGame bridgeGame = new BridgeGame(3);
        assertThat(bridgeGame.isCorrectInput("U","D")).isEqualTo("X");
    }

    @DisplayName("플레이어의 입력이 맞았을때 O반환")
    @Test
    void isCorrect_wrong() {
        BridgeGame bridgeGame = new BridgeGame(3);
        assertThat(bridgeGame.isCorrectInput("U","U")).isEqualTo("O");
}
}