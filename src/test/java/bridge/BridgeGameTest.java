package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameTest {

    @DisplayName("게임을 재시작할 때마다, 게임 시도 횟수를 1 증가시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    public void 게임_시도_횟수_기록(int targetTryCount) {
        BridgeGame bridgeGame = new BridgeGame();

        for (int count = 0; count < targetTryCount; count++) {
            bridgeGame.retry();
        }

        Assertions.assertThat(bridgeGame.getGameTryCount()).isEqualTo(targetTryCount + 1);
    }
}
