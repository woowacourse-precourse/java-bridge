package bridge.domain.direction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @DisplayName("생성자 메소드에 U와 D를 제외한 문자가 입력되었을 때 오류를 발생시키는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"u", "25", "", " ", " U", "D ", "UU", "DU"})
    void constructor_error_test(String input) {
        assertThatThrownBy(() -> new Direction(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] U 혹은 D만 입력할 수 있습니다.");
    }

    @DisplayName("생성자 메소드에 U와 D를 입력하였을 때 Direction 객체가 생성되는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"U", "D"})
    void constructor_test(String input) {
        Direction direction = new Direction(input);

        assertThat(direction).isInstanceOf(Direction.class);
    }

}