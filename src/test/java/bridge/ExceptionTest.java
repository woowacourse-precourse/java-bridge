package bridge;

import bridge.constant.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    @DisplayName("3~20 사이의 수가 아닌 알파벳 입력 시 예외 발생")
    @Test
    void checkValidateInputtype() {
        assertThatThrownBy(() -> Exception.validateBridgeSize("a"))
                .hasMessageContaining(Error.ERROR_RANGE.getError())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이 입력이 3부터 20사이의 수가 아니라면 예외 발생")
    @Test
    void checkRangefalse() {
        assertThatThrownBy(() -> Exception.validateBridgeSize("2"))
                .hasMessageContaining(Error.ERROR_RANGE.getError())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3부터 20사이의 수라면 예외가 발생하지 않음")
    @Test
    void checkRangetrue() {
        assertThatCode(() -> Exception.validateBridgeSize("15"))
                .doesNotThrowAnyException();
    }

    @DisplayName("이동할 칸 입력 시, U와 D 이외의 알파벳 입력 시 예외 발생")
    @Test
    void checkUandD() {
        assertThatThrownBy(() -> Exception.validateMoving("A"))
                .hasMessageContaining(Error.ERROR_MOVING.getError())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("U 혹은 D가 입력된다면 예외가 발생하지 않음")
    @Test
    void checkInput() {
        assertThatCode(() -> Exception.validateMoving("U"))
                .doesNotThrowAnyException();
    }

    @DisplayName("R, Q 이외의 알파벳 입력 시 예외 발생")
    @Test
    void occurException() {
        assertThatThrownBy(() -> Exception.validateGameCommand("U"))
                .hasMessageContaining(Error.ERROR_RESTART.getError())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R 혹은 Q가 입력된다면 예외가 발생하지 않음")
    @Test
    void notoccurException() {
        assertThatCode(() -> Exception.validateGameCommand("R"))
                .doesNotThrowAnyException();
    }
}
