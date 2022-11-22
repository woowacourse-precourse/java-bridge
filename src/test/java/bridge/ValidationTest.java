package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @DisplayName("다리 길이 입력에 문자가 포함됐다면 예외를 발생한다.")
    @Test
    void validateInputIncludeCharacter() {
        assertThatThrownBy(() -> Validation.isInputIncludeCharacter("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력이 3미만 또는 20초과할 경우 예외를 발생한다.")
    @Test
    void validateInputBetween3And20() {
        assertThatThrownBy(() -> Validation.isInputBetweenMinAndMax(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 입력이 U 또는 D가 아닐 경우 예외를 발생한다.")
    @Test
    void validateInputUpOrDown() {
        assertThatThrownBy(() -> Validation.isInputUpOrDown("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 입력이 R 또는 Q가 아닐 경우 예외를 발생한다.")
    @Test
    void validateInputRestartOrQuit() {
        assertThatThrownBy(() -> Validation.isInputRestartOrQuit("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
