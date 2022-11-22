package bridge.input.validator;

import bridge.input.validator.code.BridgeSizeValidationCode;
import bridge.input.validator.BridgeSizeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeSizeValidatorTest {

    @ParameterizedTest
    @DisplayName("다리 길이 입력 검증: 숫자가 아닌 문자열인 경우")
    @ValueSource(strings = {"invalid", "3.54", "", "6555.", "30120301a"})
    void validateBridgeSizeTest_invalidCase_1(String userInput) {
        BridgeSizeValidator validator = new BridgeSizeValidator();
        assertThat(validator.validateBridgeSize(userInput))
                .isEqualTo(BridgeSizeValidationCode.ILLEGAL_CHARACTER);
    }

    @ParameterizedTest
    @DisplayName("다리 길이 입력 검증: 숫자이지만 잘못된 형식의 숫자인 경우")
    @ValueSource(strings = {"-3", "-20", "+03", "020"})
    void validateBridgeSizeTest_invalidCase_2(String userInput) {
        BridgeSizeValidator validator = new BridgeSizeValidator();
        assertThat(validator.validateBridgeSize(userInput))
                .isEqualTo(BridgeSizeValidationCode.INVALID_NUMBER_FORMAT);
    }

    @ParameterizedTest
    @DisplayName("다리 길이 입력 검증: 올바른 숫자 형식이지만 범위를 벗어난 경우")
    @ValueSource(strings = {"0", "1", "2", "21", "22","150", })
    void validateBridgeSizeTest_invalidCase_3(String userInput) {
        BridgeSizeValidator validator = new BridgeSizeValidator();
        assertThat(validator.validateBridgeSize(userInput))
                .isEqualTo(BridgeSizeValidationCode.NUMBER_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @DisplayName("다리 길이 입력 검증: 올바른 형식/범위의 숫자인 경우")
    @ValueSource(strings = {"3", "4", "5" ,"6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"})
    void validateBridgeSizeTest_validCase(String userInput) {
        BridgeSizeValidator validator = new BridgeSizeValidator();
        assertThat(validator.validateBridgeSize(userInput))
                .isEqualTo(BridgeSizeValidationCode.VALID);
    }
}
