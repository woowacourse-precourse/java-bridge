package Exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CheckExceptionTest {

    @DisplayName("다리 길이 입력이 3과 20 사이의 숫자가 아니면 예외발생")
    @ValueSource(strings = {"-1", "0", "22"})
    @ParameterizedTest
    void inputBridgeSizeByOutOfRange(String size) {
        assertThatThrownBy(() -> CheckException.bridgeSizeException(size))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("다리 길이 입력에 문자가 포함된 경우 예외발생")
    @ValueSource(strings = {"a", "1b", "0c0"})
    @ParameterizedTest
    void inputBridgeSizeByCharacter(String size) {
        assertThatThrownBy(() -> CheckException.bridgeSizeException(size))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("이동할 칸을 입력했을 때 대문자 D와 U가 아니면 예외 발생")
    @ValueSource(strings = {"d", "u", "1"})
    @ParameterizedTest
    void inputMovingByInvaidValue(String movig) {
        assertThatThrownBy(() -> CheckException.movingException(movig))
                .isInstanceOf(IllegalArgumentException.class);
    }

}