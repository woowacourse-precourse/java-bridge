package validation;

import bridge.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("다리 길이 입력 시 숫자가 아닌 다른 입력의 경우 예외가 발생한다.")
    @Test
    void isNumber() {
        assertThatThrownBy(() -> validator.validateBridgeLength("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("다리 길이 입력 시 3 ~ 20의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void isCorrectRange() {
        assertThatThrownBy(() -> validator.validateBridgeLength("21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("다리 이동 입력 시 U와 D가 아닐 경우 예외가 발생한다.")
    @Test
    void isUAndD() {
        assertThatThrownBy(() -> validator.validateMovement("X"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("U와 D 중 하나를 입력해주세요.");
    }

    @DisplayName("게임 재시작, 종료 입력 시 R과 D가 아닐 경우 예외가 발생한다.")
    @Test
    void isRAndD() {
        assertThatThrownBy(() -> validator.validateRestartOrQuit("X"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("R와 Q 중 하나를 입력해주세요.");
    }
}