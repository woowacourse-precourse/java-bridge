package bridge.domain.bridge_game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.bridge_game.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @ParameterizedTest(name = "Position.of({0})을 입력하면 {0} 값을 가진 Position이 반환된다.")
    @ValueSource(ints = {0, 10, 19})
    void ofSuccess(int value) {
        Position position = Position.of(value);
        assertThat(position.value()).isEqualTo(value);
    }

    @ParameterizedTest(name = "Position.of() 메서드에 0~19 이외의 값을 입력하면 예외를 발생시킨다. 입력: {0}")
    @ValueSource(ints = {-1, 20, 35})
    void ofFail(int value) {
        assertThatThrownBy(() -> Position.of(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Player의 위치 값은 0~19까지만 가능합니다.");
    }

    @ParameterizedTest(name = "increase() 메서드를 호출하면 값이 1 증가된 Position이 반환된다. 입력: {0}")
    @ValueSource(ints = {0, 10, 18})
    void increaseSuccess(int value) {
        Position position = Position.of(value);
        Position increasedPosition = position.increase();
        assertThat(increasedPosition.value()).isEqualTo(value + 1);
    }

    @DisplayName("increase()를 호출하여 값이 1 증가되었을 때 19를 초과하면 예외를 발생시킨다.")
    @Test
    void increaseFail() {
        Position position = Position.of(19);
        assertThatThrownBy(position::increase)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Player의 위치 값은 0~19까지만 가능합니다.");
    }

    @DisplayName("reset() 메서드를 호출하면 가진 값이 0인 Position이 반환된다.")
    @Test
    void reset() {
        Position position = Position.of(19);
        Position reset = position.reset();
        assertThat(reset.value()).isEqualTo(0);
    }
}