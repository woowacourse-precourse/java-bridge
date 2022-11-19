package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {

    @DisplayName("게임을 재시작할 때마다, 게임 시도 횟수를 1 증가시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    public void 게임_시도_횟수_기록(int targetTryCount) {
        BridgeGame bridgeGame = new BridgeGame();

        iterateGameTry(bridgeGame, targetTryCount);

        Assertions.assertThat(bridgeGame.getGameTryCount()).isEqualTo(targetTryCount + 1);
    }

    @DisplayName("오버플로우가 발생할 수 있을 정도로 게임을 시도하면, 예외를 발생시킨다.")
    @Test
    public void 게임_시도_횟수_오버플로우_방지() {
        BridgeGame bridgeGame = new BridgeGame();

        assertThatThrownBy(() -> iterateGameTry(bridgeGame, Integer.MAX_VALUE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 너무 많은 게임 시도는 건강에 해롭습니다. 게임을 종료합니다.");
    }

    public void iterateGameTry(BridgeGame bridgeGame, int targetTryCount) {
        for (int count = 0; count < targetTryCount; count++) {
            bridgeGame.retry();
        }
    }
}
