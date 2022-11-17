package bridge.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"A", "", " ", "하나", "!"})
    void validateBridgeSize_메서드는_숫자가_아닌_값을_입력하면_IllegalArgumentException을_던진다(String inputSize) {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(inputSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 숫자 형식입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "21", "9999"})
    void validateBridgeSize_메서드는_범위를_벗어난_값을_입력하면_IllegalArgumentException을_던진다(String inputSize) {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(inputSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리의 길이는 3에서 20 사이의 값이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "13", "20"})
    void validateBridgeSize_메서드는_범위_내_값을_입력하면_예외를_던지지_않는다(String inputSize) {
        inputValidator.validateBridgeSize(inputSize);
    }
}
