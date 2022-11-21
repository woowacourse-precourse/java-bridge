package exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ExceptionMessage 테스트")
class ExceptionMessageTest {

    @DisplayName("INVALID_BRIDGE_SIZE 테스트")
    @Test
    void bridgeSize() {
        ExceptionMessage invalidBridgeSize = ExceptionMessage.INVALID_BRIDGE_SIZE;
        String message = invalidBridgeSize.getMessage();
        assertThat(message).isEqualTo("[ERROR] 잘못된 입력 입니다. 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("INVALID_MOVE 테스트")
    @Test
    void move() {
        ExceptionMessage invalidMove = ExceptionMessage.INVALID_MOVE;
        String message = invalidMove.getMessage();
        assertThat(message).isEqualTo("[ERROR] 잘못된 입력 입니다. U(위), D(아래)를 입력해 주세요.");
    }

    @DisplayName("INVALID_INPUT 테스트")
    @Test
    void input() {
        ExceptionMessage invalidInput = ExceptionMessage.INVALID_INPUT;
        String message = invalidInput.getMessage();
        assertThat(message).isEqualTo("[ERROR] 잘못된 입력 입니다. 알맞게 입력해 주세요.");
    }
}