package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    @DisplayName("사용자가 입력한 값이 비어있다면 예외가 발생한다.")
    @Test
    public void checkInputByNull() {
        assertThatThrownBy(() -> Exception.validateByNull(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 값이 숫자 이외의 값이라면 예외가 발생한다.")
    @Test
    public void checkInputByNotNumber() {
        assertThatThrownBy(() -> Exception.validateByNotNumber("aa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 다리 길이가 [3, 20]을 벗어나면 예외가 발생한다.")
    @Test
    public void checkBridgeSizeByOverRange() {
        assertThatThrownBy(() -> Exception.validateByOverRange(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U, D를 제외한 값이 입력되면 예외가 발생한다.")
    @Test
    public void checkInputByNotUOrD() {
        assertThatThrownBy(() -> Exception.validateByNotUOrD("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R, Q를 제외한 값이 입력되면 예외가 발생한다.")
    @Test
    public void checkInputByNotROrQ() {
        assertThatThrownBy(() -> Exception.validateByNotUOrD("B"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
