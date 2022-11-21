package bridge.domain;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    @DisplayName("올바른 칸 이동")
    @Test
    void move() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.move("U")).isEqualTo(true);
        assertThat(bridgeGame.move("D")).isEqualTo(true);
        assertThat(bridgeGame.move("U")).isEqualTo(false);
    }

    @DisplayName("이동시 잘못된 입력값인 경우")
    @Test
    void moveByInvaildInput() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThatThrownBy(
                () -> bridgeGame.move("u")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 재시작 명령어")
    @Test
    void retryByCommand() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
    }

    @DisplayName("올바른 종료 명령어")
    @Test
    void quitByCommand() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }

    @DisplayName("재시작,종료시 잘못된 명령어 입력")
    @Test
    void commandByInvaildInput() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThatThrownBy(
                () -> bridgeGame.retry("q")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("승리 확인")
    @Test
    void checkwin() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.checkWin()).isEqualTo(true);
    }
}
