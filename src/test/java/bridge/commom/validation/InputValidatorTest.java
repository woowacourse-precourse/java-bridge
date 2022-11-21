package bridge.commom.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("다리의 사이즈를 알기위해서, 사용자의 입력을 받을 때 양의 정수가 아니라면 예외를 발생한다.")
    @ParameterizedTest(name = "양의 정수 유효성 검사 테스트[{index}] => {0}은 양의 정수가 아니다.  ")
    @ValueSource(strings = {"3.14", "0", "-1", "-2", "65.123", "-0.1", "abc", "양의 정수"})
    void ifInputValueInReadSizeIsNotPositiveIntegerThenThrowException(String actual) {
        assertThatThrownBy(() -> InputValidator.isPositiveInteger(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양의 정수만 입력할 수 있습니다.");
    }

    @DisplayName("사용자가 어디로 이동할지 알기위해서, 사용자의 입력을 받을 때 U 혹은 D가 아니라면 예외를 발생한다.")
    @ParameterizedTest(name = "이동 명령어 유효성 검사 테스트[{index}] => {0}은 U 혹은 D가 아니다.  ")
    @ValueSource(strings = {"A", "0", "-1", "B", "65.123", "-0.1", "abc", "u", "d"})
    void ifInputValueInMoveCommandIsNotUOrDThenThrowException(String actual) {
        assertThatThrownBy(() -> InputValidator.isMoveModeCommand(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("U(위로 이동) 혹은 D(아래로 이동) 중 하나를 입력해야합니다.");
    }

    @DisplayName("사용자가 실패했을 때 재시작 여부를 알기위해서, 사용자의 입력을 받을 때 R 혹은 Q가 아니라면 예외를 발생한다.")
    @ParameterizedTest(name = "이동 명령어 유효성 검사 테스트[{index}] => {0}은 R 혹은 Q가 아니다.  ")
    @ValueSource(strings = {"A", "0", "-1", "B", "65.123", "-0.1", "abc", "u", "d"})
    void ifInputValueInRestartCommandIsNotROrQThenThrowException(String actual) {
        assertThatThrownBy(() -> InputValidator.isRestartModeCommand(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("R(재시작) 혹은 Q(종료) 중 하나를 입력해야합니다.");
    }
}