package bridge;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
