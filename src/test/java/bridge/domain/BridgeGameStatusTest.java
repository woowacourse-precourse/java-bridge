package bridge.domain;

import bridge.domain.BridgeGameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BridgeGameStatusTest {

    @DisplayName("사용자가 재시도,종료 여부에 R또는 Q가 아닌 값을 입력했을 때 예외를 던지는지 테스트")
    @Test
    void changeStatusByInvalidInput() {
        //given
        String command = "C";
        BridgeGameStatus status = new BridgeGameStatus(command);
        //when
        //then
        assertThatThrownBy(() -> {
            status.changeStatus(command);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("command 값이 R과 동일해서 계속 실행이 가능한 상태라면 참을 반환하는지 테스트")
    @Test
    void isRunning() {
        //given
        BridgeGameStatus status = new BridgeGameStatus("R");
        //when
        boolean isRunning = status.isRunning();
        //then
        assertThat(isRunning)
                .isTrue();
    }

    @DisplayName("command 값이 R과 동일하지 않아서 계속 실행이 불가능한 상태라면 거짓을 반환하는지 테스트")
    @Test
    void isNotRunning() {
        //given
        BridgeGameStatus status = new BridgeGameStatus("Q");
        //when
        boolean isRunning = status.isRunning();
        //then
        assertThat(isRunning)
                .isFalse();
    }
}