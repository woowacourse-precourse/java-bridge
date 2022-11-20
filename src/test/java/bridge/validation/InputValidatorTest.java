package bridge.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("입력된 다리 크기가 조건에 맞지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"1", "21", "0"})
    @ParameterizedTest
    void makeBridgeWithWrongInputSize(String size) {
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리 길이는 3이상, 20이하의 크기만 가능합니다.");
    }

    @DisplayName("입력된 다리 크기가 숫자가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"a", "@", " "})
    @ParameterizedTest
    void makeBridgeWithWrongInputCondition(String size) {
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리 길이는 숫자만 입력할 수 있습니다.");
    }

    @DisplayName("입력된 움직임 방향이 조건과 맞지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"A", "S", "J"})
    @ParameterizedTest
    void makeMovingWithWrongInputCondition(String moving) {
        assertThatThrownBy(() -> InputValidator.checkMovingChoice(moving))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리 선택은 알파벳 U, D만 입력할 수 있습니다.");
    }


    @DisplayName("재시도 여부가 조건과 맞지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"@", " ", "A"})
    @ParameterizedTest
    void makeRetryWithWrongInputCondition(String retryIntention) {
        assertThatThrownBy(() -> InputValidator.checkRetryIntention(retryIntention))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 재시작 여부는 알파벳 R, Q만 입력할 수 있습니다.");
    }
}