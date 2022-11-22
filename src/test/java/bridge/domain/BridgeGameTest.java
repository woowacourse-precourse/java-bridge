package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    Bridge bridge = new Bridge(List.of("U", "D", "D"));
    BridgeGame bridgeGame = new BridgeGame(bridge);

    @DisplayName("올바른 칸 이동")
    @Test
    void move() {
        assertThat(bridgeGame.move("U")).isEqualTo(true);
        assertThat(bridgeGame.move("D")).isEqualTo(true);
        assertThat(bridgeGame.move("U")).isEqualTo(false);
    }

    @DisplayName("이동시 잘못된 입력값인 경우")
    @Test
    void moveByInvaildInput() {
        assertThatThrownBy(
                () -> bridgeGame.move("u")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 재시작 명령어")
    @Test
    void retryByCommand() {
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
    }

    @DisplayName("올바른 종료 명령어")
    @Test
    void quitByCommand() {
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }

    @DisplayName("재시작,종료시 잘못된 명령어 입력")
    @Test
    void commandByInvaildInput() {
        assertThatThrownBy(
                () -> bridgeGame.retry("q")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("승리 확인")
    @Test
    void checkwin() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.checkWin()).isEqualTo(true);
    }
}
