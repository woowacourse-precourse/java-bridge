package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandTypeTest {


    @Test
    @DisplayName("Q,R 이 아닌 값을 인자로받으면 예외 발생")
    public void 예외테스트() {
        assertThatThrownBy(() -> CommandType.create("U"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] Q 또는 R 를 입력해야 합니다.");
    }
}