package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BridgeGameStatusTest {

    @DisplayName("사용자가 재시도,종료 여부에 R또는 Q가 아닌 값을 입력했을 때 예외를 던지는지 테스트")
    @Test
    void changeBridgeGameStatusByInvalidInput() {
        //given
        String command = "C";
        BridgeGameStatus status = new BridgeGameStatus(command);
        //when
        //then
        Assertions.assertThatThrownBy(() -> {
                      status.changeStatus(command);
                  })
                  .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isRunning() {
    }

    @Test
    void changeStatus() {
    }
}