package bridge;

import bridge.service.BridgeGame;
import bridge.vo.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class GameRetryCountTest {

    private static final int MAX_TRY_COUNT = 100000;

    @DisplayName("게임을 재시작할 때마다, 게임 시도 횟수를 1 증가시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    public void 게임_시도_횟수_기록(int targetTryCount) {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "D"));

        iterateGameTry(bridgeGame, targetTryCount);

        Assertions.assertThat(bridgeGame.getGameTryCount()).isEqualTo(targetTryCount + 1);
    }

    @DisplayName("100000번 이상 게임을 시도하면, 예외를 발생시킨다(오버플로우 사전에 방지).")
    @Test
    public void 게임_시도_횟수_오버플로우_방지() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "D"));

        Assertions.assertThatThrownBy(() -> iterateGameTry(bridgeGame, MAX_TRY_COUNT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.GAME_TRY_COUNT_OVER_MESSAGE.toString());
    }

    public void iterateGameTry(BridgeGame bridgeGame, int targetTryCount) {
        for (int count = 0; count < targetTryCount; count++) {
            bridgeGame.retry("R");
        }
    }
}
