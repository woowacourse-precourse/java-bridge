package bridge.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    @DisplayName("다리 길이 입력 시 숫자를 입력하지 않으면 예외 처리한다.")
    @Test
    void setBridgeSizeToNonNumeric() {
        assertThatThrownBy(() -> Validator.validateBridgeSize("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력 시 3 이상 20 이하의 숫자를 입력하지 않으면 예외 처리한다.")
    @Test
    void setBridgeSizeToInvalidRange() {
        assertThatThrownBy(() -> Validator.validateBridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸 입력 시 U, D 이외의 값이 입력되면 예외 처리한다")
    @Test
    void inputInvalidMove() {
        assertThatThrownBy(() -> Validator.validateMove("d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작/종료 여부를 입력 시 R, Q 이외의 값이 입력되면 예외 처리한다.")
    @Test
    void inputInvalidCommand() {
        assertThatThrownBy(() -> Validator.validateGameCommand("E"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작/종료 여부를 입력 시 R, Q 이 정확히 입력되면 예외처리를 하지 않는다.")
    @Test
    void inputValidCommand() {
        assertThatCode(() -> Validator.validateGameCommand(Value.QUIT))
                .doesNotThrowAnyException();
    }
}