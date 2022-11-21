package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.userInfo.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @DisplayName("방향이 공백이라면 예외가 발생한다.")
    @Test
    void createDirectionWithBlank() {
        assertThatThrownBy(() -> new Direction(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방향이 U 또는 D 가 아니라면 예외가 발생한다.")
    @Test
    void createDirectionWithInvalidCharacter() {
        assertThatThrownBy(() -> new Direction("r"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}