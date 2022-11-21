package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.User.ValidUserInput;

public class UserTest {
    @DisplayName("사용자가 입력한 방향이 'U' or 'D'가 아니면 예외 발생")
    @Test
    void movingNotUandD() {
        assertThatThrownBy(() -> {
            ValidUserInput.checkInputUpAndDown("P");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 command가 'R' or 'Q'가 아니면 예외 발생")
    @Test
    void commandNotRandQ() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> {
            ValidUserInput.commandIsRorQ("P");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
