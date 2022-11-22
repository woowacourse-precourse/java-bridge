package bridge.model;

import bridge.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    @DisplayName("다리 길이 입력값이 숫자가 아닐 경우 예외 발생")
    @ValueSource(strings = {"a", "1,2"})
    @ParameterizedTest
    void notNumber(String input) {
        assertThatThrownBy(() -> Validator.validateSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_NUMBER_POSSIBLE.getMessage());
    }

    @DisplayName("다리 길이 입력값이 허용 범위를 넘을 경우 예외 발생")
    @ValueSource(strings = {"1", "30", "-1"})
    @ParameterizedTest
    void outOfRange(String input) {
        assertThatThrownBy(() -> Validator.validateSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE.getMessage());
    }

    @DisplayName("이동할 칸 입력값이 U 또는 D가 아닌 경우 예외 발생")
    @ValueSource(strings = {"aaa", " ", "d"})
    @ParameterizedTest
    void onlyUDPossible(String input) {
        assertThatThrownBy(() -> Validator.validateMove(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_U_OR_D_POSSIBLE.getMessage());
    }

    @DisplayName("게임 재시작 여부 입력값이 R 또는 Q가 아닌 경우 예외 발생")
    @ValueSource(strings = {"aaa", " ", "d"})
    @ParameterizedTest
    void onlyRQPossible(String input) {
        assertThatThrownBy(() -> Validator.validateCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_R_OR_Q_POSSIBLE.getMessage());
    }
}
