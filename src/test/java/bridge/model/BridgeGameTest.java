package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();
    int bridgeSize = 3;


    @DisplayName("다리가 위 칸일 때, 사용자가 U와 D를 입력한 경우 테스트")
    @Test
    void moveStageWhenBridgeStageIsUpTest() {
        bridgeGame.move("U", "U", bridgeSize);
        bridgeGame.move("D", "U", bridgeSize);

        Assertions.assertThat(bridgeGame.getCurrentPositions()).isEqualTo(List.of(List.of(" ", "O"), List.of("X", " ")));
    }

    @DisplayName("다리가 아래 칸일 때, 사용자가  U와 D를 입력한 경우 테스트")
    @Test
    void moveStageWhenBridgeStageIsDownTest() {
        bridgeGame.move("U", "D", bridgeSize);
        bridgeGame.move("D", "D", bridgeSize);

        Assertions.assertThat(bridgeGame.getCurrentPositions()).isEqualTo(List.of(List.of(" ", "X"), List.of("O", " ")));
    }


    @DisplayName("재시작하는 경우 초기화 확인 테스트")
    @Test
    void retryThenCurrentMapClearTest() {
        bridgeGame.move("D", "U", bridgeSize);
        bridgeGame.move("D", "D", bridgeSize);
        bridgeGame.retry();

        Assertions.assertThat(bridgeGame.getCurrentPositions()).isEmpty();
    }

    @DisplayName("틀려서 초기화한 경우 사이즈와 시도 횟수를 확인하는 테스트")
    @Test
    void retry() {
        bridgeGame.move("U", "U", bridgeSize);
        bridgeGame.move("D", "D", bridgeSize);
        bridgeGame.move("U", "D", bridgeSize);
        bridgeGame.retry();

        assertThat(bridgeGame.nextIndex()).isEqualTo(0);
        assertThat(bridgeGame.getNumberOfAttempts()).isEqualTo(2);
    }

    @DisplayName("맞히기만 경우 isFail()가 false 반환 테스트")
    @Test
    void isNotFailTest() {
        bridgeGame.move("U", "U", bridgeSize);
        bridgeGame.move("D", "D", bridgeSize);
        assertThat(bridgeGame.isFail()).isFalse();
        assertThat(bridgeGame.nextIndex()).isEqualTo(2);
    }

    @DisplayName("틀린 경우 isFail()가 True 반환 테스트")
    @Test
    void isFailTest() {
        bridgeGame.move("U", "U", bridgeSize);
        bridgeGame.move("D", "D", bridgeSize);
        bridgeGame.move("U", "D", bridgeSize);

        assertThat(bridgeGame.isFail()).isTrue();
        assertThat(bridgeGame.nextIndex()).isEqualTo(3);
        assertThat(bridgeGame.getOutcome()).isEqualTo("실패");
    }

    @DisplayName("맞은 경우 isSuccess()가 True 반환 테스트")
    @Test
    void isSuccessTest() {
        bridgeGame.move("U", "U", bridgeSize);
        bridgeGame.move("D", "D", bridgeSize);
        bridgeGame.move("U", "U", bridgeSize);

        assertThat(bridgeGame.isSuccess()).isTrue();
        assertThat(bridgeGame.nextIndex()).isEqualTo(3);
        assertThat(bridgeGame.getOutcome()).isEqualTo("성공");
    }

}