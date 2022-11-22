package bridge.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DirectionTest {

    @DisplayName("방향이 U 또는 D 가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"'r'", "'4'", "'!'", "'u'"})
    void createLength_with_invalid_size(String direction) {
        assertThatThrownBy(() -> new Direction(direction))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방향이 공백이라면 예외가 발생한다.")
    @Test
    void createDirectionWithBlank() {
        assertThatThrownBy(() -> new Direction(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
