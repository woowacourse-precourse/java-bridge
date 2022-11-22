package validation;

import model.BridgeSize;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidationTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"j", "값", ".", "1 2"})
    void 다리의_길이_입력_값이_숫자가_아닐_경우_예외_처리(String input) {
        assertThatThrownBy(() -> new BridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining("다리의 길이는 숫자이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "21", "2", "1000"})
    void 다리의_길이_입력_값이_3이상_20이하가_아닐_경우_예외_처리(int input) {
        assertThatThrownBy(() -> Validation.ofBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining("다리의 길이는 3 이상 20 이하의 숫자이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "u", "d", "UU", "DD", "10U", "U  "})
    void 이동할_칸_입력_값이_U_또는_D가_아닐_경우_예외_처리(String input) {
        assertThatThrownBy(() -> Validation.ofMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining("이동할 칸은 위는 U, 아래는 D로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "r", "q", "RR", "QQ", "11R", "Q  "})
    void 다시_시도_여부가_R_또는_Q가_아닐_경우_예외_처리(String input) {
        assertThatThrownBy(() -> Validation.ofRestart(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining("재시도는 R, 종료는 Q로 입력해야 합니다.");
    }
}
