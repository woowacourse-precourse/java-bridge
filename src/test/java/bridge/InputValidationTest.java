package bridge;

import bridge.validation.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputValidationTest {

    @DisplayName("올바르지 않은 다리 길이에 대한 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "0", "21", "999"})
    void 다리_길이_예외_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidation.validateReadBridgeSize(input));
    }

    @DisplayName("올바르지 않은 이동할 칸에 대한 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1", "S", "BRO", " 우아한"})
    void 이동할_칸_예외_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidation.validateReadMoving(input));
    }

    @DisplayName("올바르지 않은 게임 재시작 여부에 대한 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "D", "U", "BRO", " 우아한"})
    void 게임_재시작_여부_예외_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidation.validateReadGameCommand(input));
    }
}
