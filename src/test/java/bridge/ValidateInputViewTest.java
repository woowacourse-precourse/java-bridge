package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ValidateInputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 크기 값이 정수가 아닐 때의 예외 처리")
    @ValueSource(strings = {"abc", "a1c", "1.1"})
    @ParameterizedTest
    void 다리_크기_정수_입력_테스트(String input) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new ValidateInputView().validateBridgeSize(input)).isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 크기 값이 3 이상 20 이하의 자연수가 아닐 때의 예외 처리")
    @ValueSource(strings = {"2", "21", "-1"})
    @ParameterizedTest
    void 다리_크기_자연수_범위_테스트(String input) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new ValidateInputView().validateBridgeSize(input)).isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("이동값이 U또는 D가 아닐 때의 예외처리")
    @ValueSource(strings = {"", "UD", "DU", "ABC", "u", "d", "R", "Q"})
    @ParameterizedTest
    void 이동_문자열_테스트(String input) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new ValidateInputView().validateMove(input)).isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("재시작 입력값이 R또는 Q가 아닐 때의 예외처리")
    @ValueSource(strings = {"", "UD", "DU", "ABC", "u", "d", "U", "D", "RA", "RQ"})
    @ParameterizedTest
    void 재시작_문자열_테스트(String input) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new ValidateInputView().validateGameCommand(input)).isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
