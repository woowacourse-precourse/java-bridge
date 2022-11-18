package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();


    @DisplayName("다리가 위 칸일 때, 사용자가 U과 D을 입력한 경우 테스트")
    @Test
    void saveStageWhenBridgeStageIsUp() {
        bridgeGame.move("U", "U");
        bridgeGame.move("D", "U");

        Assertions.assertThat(bridgeGame.getCurrentPositions()).isEqualTo(List.of(List.of(" ", "O"), List.of("X", " ")));
    }

    @DisplayName("다리가 아래 칸일 때, 사용자가 U과 D을 입력한 경우 테스트")
    @Test
    void saveStageWhenBridgeStageIsDown() {
        bridgeGame.move("U", "D");
        bridgeGame.move("D", "D");

        Assertions.assertThat(bridgeGame.getCurrentPositions()).isEqualTo(List.of(List.of(" ", "X"), List.of("O", " ")));
    }


    @DisplayName("재시작하는 경우 초기화 확인 테스트")
    @Test
    void retryThenCurrentMapClear() {
        bridgeGame.move("D", "U");
        bridgeGame.move("D", "D");
        bridgeGame.retry();

        Assertions.assertThat(bridgeGame.getCurrentPositions()).isEmpty();
    }

    @DisplayName("맞히기만 경우 canNotCross()가 false 반환 테스트")
    @Test
    void success() {
        bridgeGame.move("U", "U");
        bridgeGame.move("D", "D");
        assertThat(bridgeGame.isFail()).isFalse();
        assertThat(bridgeGame.nextIndex()).isEqualTo(2);
    }

    @DisplayName("틀린 경우 canNotCross()가 True 반환 테스트")
    @Test
    void fail() {
        bridgeGame.move("U", "U");
        bridgeGame.move("D", "D");
        bridgeGame.move("U", "D");

        assertThat(bridgeGame.isFail()).isTrue();
        assertThat(bridgeGame.nextIndex()).isEqualTo(3);
        assertThat(bridgeGame.getOutcome()).isEqualTo("실패");
    }

    @DisplayName("틀려서 초기화한 경우 사이즈와 시도 횟수를 확인하는 테스트")
    @Test
    void retry() {
        bridgeGame.move("U", "U");
        bridgeGame.move("D", "D");
        bridgeGame.move("U", "D");
        bridgeGame.retry();

        assertThat(bridgeGame.nextIndex()).isEqualTo(0);
        assertThat(bridgeGame.getNumberOfAttempts()).isEqualTo(2);

    }
}
