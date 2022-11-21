package bridge.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BridgeControllerTest {
    ValidateInput validate;
    @BeforeEach
    void beforeEach() {
        validate = new ValidateInput();
    }

    @DisplayName("다리의 길이를 숫자로 입력 받지 않는 경우 예외처리.")
    @ParameterizedTest
    @CsvSource({"h", "A", "영"})
    void inputBridgeLengthByNotNumeric(String input) {
        assertThatThrownBy(() -> validate.numeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임이 실패 하고 다른 문자가 입력 되는 경우 예외처리.")
    @ParameterizedTest
    @CsvSource({"-1", "r", "다"})
    void inputEndLetterByAnotherLetter(String input) {
        assertThatThrownBy(() -> validate.endLetter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}