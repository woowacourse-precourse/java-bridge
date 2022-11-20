package bridge;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {

    @DisplayName("생성된 다리 길이가 입력값과 동일한지 테스트")
    @Test()
    public void createBridge() {
        BridgeGame bridgeGame = new BridgeGame(5);
        assertThat(bridgeGame.getBridgeSize())
                .isEqualTo(5);
    }

    @DisplayName("다리 건너기를 성공했을 경우 올바른 값을 반환하는지 테스트")
    @Test()
    public void successMove() {
        BridgeGame bridgeGame = new BridgeGame(3);
        bridgeGame.setBridge(List.of("U", "D", "D"));
        assertThat(bridgeGame.move(0, "U"))
                .isTrue();
    }

    @DisplayName("다리 건너기를 실패했을 경우 올바른 값을 반환하는지 테스트")
    @Test()
    public void failMove() {
        BridgeGame bridgeGame = new BridgeGame(3);
        bridgeGame.setBridge(List.of("U", "D", "D"));
        assertThat(bridgeGame.move(0, "D"))
                .isFalse();
    }

    @DisplayName("재시도 시 게임 시도 횟수가 1 증가하는지 테스트")
    @Test()
    public void countGameByRetry() {
        BridgeGame bridgeGame = new BridgeGame(3);
        bridgeGame.retry();
        bridgeGame.retry();
        assertThat(bridgeGame.getGameCount())
                .isEqualTo(3);
    }

    @DisplayName("범위를 벗어난 다리 길이를 입력한 경우 예외 발생")
    @Test()
    public void bridgeSizeByInvalidInput() {
        assertThatThrownBy(() -> Validation.validateBridgeSizeInput("30"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 건너기를 할 때 잘못된 입력값을 입력한 경우 예외 발생")
    @Test()
    public void moveByInvalidInput() {
        assertThatThrownBy(() -> Validation.validateMovingInput("UD"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도 물음에 잘못된 입력값을 입력한 경우 예외 발생")
    @Test()
    public void retryCommandByInvalidInput() {
        assertThatThrownBy(() -> Validation.validateCommandInput("RQ"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
