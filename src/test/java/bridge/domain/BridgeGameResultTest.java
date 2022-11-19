package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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

    @DisplayName("다리 이동 상태를 업데이트 한다.")
    @Test
    void checkUpdateMoveState() {
        gameResult.updateMoveState("U", true);
        List<String> updatedResult = gameResult.getMoveState().getUpState();
        assertThat(updatedResult).hasSize(1);
    }

    @DisplayName("게임 결과를 '성공'으로 세팅한다.")
    @Test
    void checkSetGameResult() {
        gameResult.setSuccess();
        String actual = gameResult.getGameResult();
        assertThat(actual).isEqualTo("성공");
    }
}
