package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("건널 수 없는 칸을 선택하면 IMMOVABLE 메세지를 응답한다.")
    @Test
    void moveThenReturnImmovable() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U"));

        String responseMessage = bridgeGame.move("D");

        assertThat(responseMessage).isEqualTo(BridgeGame.IMMOVABLE);
    }

    @DisplayName("건널 수 있는 칸을 선택하면 SUCCESS 메세지를 응답한다.")
    @Test
    void moveThenReturnSuccess() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D"));

        String responseMessage = bridgeGame.move("U");

        assertThat(responseMessage).isEqualTo(BridgeGame.SUCCESS);
    }

    @DisplayName("다리를 다 건너면 FINISHED 메세지를 응답한다.")
    @Test
    void moveThenReturnFinished() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D"));

        bridgeGame.move("U");
        String responseMessage = bridgeGame.move("D");

        assertThat(responseMessage).isEqualTo(BridgeGame.FINISH);
    }

    @DisplayName("재시도하면 플레이어의 위치가 초기화된다.")
    @Test
    void retryThenPositionReset() throws Exception {
        Field position = BridgeGame.class.getDeclaredField("position");
        position.setAccessible(true);
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D"));
        bridgeGame.move("U");

        bridgeGame.retry();

        int actualPosition = (int) position.get(bridgeGame);
        assertThat(actualPosition).isEqualTo(0);
    }

    @DisplayName("재시도하면 시도 횟수를 하나 증가시킨다.")
    @Test
    void retryThenIncreaseAttempt() throws NoSuchFieldException, IllegalAccessException {
        Field attempt = BridgeGame.class.getDeclaredField("attempt");
        attempt.setAccessible(true);
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D"));
        bridgeGame.move("U");

        bridgeGame.retry();

        int actualAttempt = (int) attempt.get(bridgeGame);
        assertThat(actualAttempt).isEqualTo(2);
    }
}
