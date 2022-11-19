package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameResultTest {

    private final BridgeGameResult gameResult = new BridgeGameResult();

    @DisplayName("게임 시도 횟수를 증가시킨다.")
    @Test
    void checkIncreaseTryCount() {
        int actual = gameResult.increaseTryCount();
        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("현재까지 이동한 다리 상태를 초기화한다.")
    @Test
    void checkInitMoveState() {
        BridgeMoveState moveState = gameResult.getMoveState();
        gameResult.updateMoveState("U", true);

        gameResult.initMoveState();
        BridgeMoveState newMoveState = gameResult.getMoveState();

        boolean actual = moveState.equals(newMoveState);
        assertThat(actual).isFalse();
    }
}
