package bridge.model;

import static bridge.model.Position.ERROR_ENUM_STRING_TYPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {

    @DisplayName("U,D 아닌 다른 문자 입력시 예외 발생")
    @ValueSource(strings = {"", " ", "K", "123"})
    @ParameterizedTest
    void create_fail(String input) {
        assertThatThrownBy(() -> Position.create(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_ENUM_STRING_TYPE);
    }

    @DisplayName("U,D 입력시 정상")
    @Test
    void create_success() {
        assertThat(Position.create("U")).isEqualTo(Position.UP);
        assertThat(Position.create("D")).isEqualTo(Position.DOWN);
    }

}
