package bridge.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class GameCommandTest {

    @DisplayName("입력 커맨드가 R이나 Q인지 검증 확인")
    @Test
    void getEnum() {
        assertThatThrownBy(() -> GameCommand.getEnum("S")).isInstanceOf(IllegalArgumentException.class);
    }
}