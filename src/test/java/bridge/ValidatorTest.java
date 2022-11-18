package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest extends NsTest {
    private final Validator validator = new Validator();

    @DisplayName("다리 크기를 숫자가 아닌 값으로 입력했을 경우에 대한 예외 처리")
    @ValueSource(strings = {"fff", "4@@", "4.5"})
    @ParameterizedTest
    void bridgeSizeByString(String input) {
        assertThatThrownBy(() -> validator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
