package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExecptionTest {
    @DisplayName("구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputIsNotNumber() {
        assertThatThrownBy(() -> Exception.checkInputIsNum("a")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 숫자를 입력하면 예외가 발생한다.")
    @Test
    void inputOutOfRangeNumber() {
        assertThatThrownBy(() -> Exception.checkBridgeSizeRange(21)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Exception.checkBridgeSizeRange(2)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U, D 이외의 값을 입력하면 예외가 발생한다.")
    @Test
    void inputNotMovingString() {
        assertThatThrownBy(() -> Exception.checkMovingString("A")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Exception.checkMovingString("B")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Exception.checkMovingString("C")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Exception.checkMovingString("E")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R, Q 이외의 값을 입력하면 예외가 발생한다.")
    @Test
    void inputNotGameCommandString() {
        assertThatThrownBy(() -> Exception.checkGameCommandString("A")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Exception.checkGameCommandString("B")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Exception.checkGameCommandString("C")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Exception.checkGameCommandString("D")).isInstanceOf(IllegalArgumentException.class);
    }
}
