package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameResultTest {

    private final BridgeGameResult gameResult = new BridgeGameResult();

    @DisplayName("게임 시도 횟수를 증가시킨다.")
    @CsvSource(value = {"1", "2", "3", "4", "5"})
    @ParameterizedTest
    void checkIncreaseTryCount(int number) {
        for (int count = 1; count <= number; count++) {
            gameResult.increaseTryCount();
        }
        int actual = gameResult.getTryCount();
        assertThat(actual).isEqualTo(number);
    }

    @DisplayName("현재까지 이동한 다리 상태를 초기화한다.")
    @Test
    void checkInitMoveState() {
        BridgeMoveState moveState = gameResult.getMoveState();
        gameResult.updateMoveState(true);

        gameResult.initMoveState();
        BridgeMoveState newMoveState = gameResult.getMoveState();

        boolean actual = moveState.equals(newMoveState);
        assertThat(actual).isFalse();
    }

    @DisplayName("다리 이동 상태를 업데이트 한다.")
    @CsvSource(value = {"true", "false"})
    @ParameterizedTest
    void checkUpdateMoveState(boolean canMove) {
        gameResult.updateMoveState(canMove);
        boolean actual = gameResult.getMoveState().getLastState();
        assertThat(actual).isEqualTo(canMove);
    }

    @DisplayName("게임 결과를 업데이트 한다.")
    @CsvSource(value = {"3, true, 성공", "3, false, 실패"})
    @ParameterizedTest
    void makeSuccessResult(int size, boolean canMove, String expected) {
        for (int i = 1; i <= size; i++) {
            gameResult.updateMoveState(canMove);
            gameResult.updateResult(size);
        }
        String actual = gameResult.getResult();
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("게임 성공일 경우 true, 실패일 경우 false 확인")
    @CsvSource(value = {"3, true, true", "3, false, false"})
    @ParameterizedTest
    void checkSuccessResult(int size, boolean canMove, boolean expected) {
        for (int i = 1; i <= size; i++) {
            gameResult.updateMoveState(canMove);
            gameResult.updateResult(size);
        }
        boolean actual = gameResult.isSuccess();
        assertThat(actual).isEqualTo(expected);
    }
}
