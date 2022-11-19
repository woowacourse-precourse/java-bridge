package bridge.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputBridgeSizeValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "A", "a1", "1a", "1A"})
    void 입력한_다리_길이가_숫자가_아니면_예외_발생(String inputBridgeSize) {
        InputBridgeSizeValidator inputBridgeSizeValidator = new InputBridgeSizeValidator();

        Assertions.assertThatThrownBy(() -> inputBridgeSizeValidator.validate(inputBridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("다리 길이는 숫자여야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1", "21", "100"})
    void 입력한_다리_길이가_3부터_20_범위가_아니면_예외_발생(String inputBridgeSize) {
        InputBridgeSizeValidator inputBridgeSizeValidator = new InputBridgeSizeValidator();

        Assertions.assertThatThrownBy(() -> inputBridgeSizeValidator.validate(inputBridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("다리 길이는 3이상 20이하여야합니다.");
    }
}