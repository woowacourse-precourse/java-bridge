package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private static BridgeGame bridgeGame = new BridgeGame();

    @BeforeAll
    public static void setBridge() {
        bridgeGame.bridge = List.of("U", "D");
        bridgeGame.bridgeSize = 2;
    }

    @DisplayName("설정된 다리에 따라 이동 방향에 따른 결과를 반환한다.")
    @Test
    void moveBridge() {
        assertThat(bridgeGame.move("U")).isEqualTo("O");
        assertThat(bridgeGame.move("U")).isEqualTo("X");
    }

    @DisplayName("R을 입력받으면 게임 재시작, Q를 입력받으면 게임 종료를 확인한다.")
    @Test
    void retryGame() {
        assertThat(bridgeGame.retry("R")).isEqualTo(false);
        assertThat(bridgeGame.retry("Q")).isEqualTo(true);
    }
}
