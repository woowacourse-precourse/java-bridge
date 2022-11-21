package bridge.validator;

import bridge.contoller.BridgeGameController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValueValidatorTest {
    @DisplayName("값이 R(재시작)또는 Q(종료)가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"r", "q", "B", "U"})
    @ParameterizedTest
    void userSelectionWithInvalidOptionTest(String input){
        ValueValidator validator = new ValueValidator();
        assertThatThrownBy(()->{validator.validateRetryOrQuit(input);}).isInstanceOf(IllegalArgumentException.class);
    }
}