package bridge.controller;

import bridge.exception.ValidationUtils;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BridgeControllerTest {

//
//    @DisplayName("다리의 길이를 숫자로 반환한다")
//    @ParameterizedTest
//    @CsvSource({"3, 3", "200, 200", "10, 10"})
//    void inputBridgeLengthByNotNumeric(String input, int expected) {
//        int actual = validate.numeric(input);
//        assertThat(actual).isEqualTo(expected);
//    }
    @DisplayName("다리의 길이를 숫자로 입력 받지 않는 경우 예외처리.")
    @ParameterizedTest
    @CsvSource({"h", "A", "영"})
    void inputBridgeLengthByNotNumeric(String input) {
        assertThatThrownBy(() -> ValidationUtils.numeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리의 길이가 맞지 않는 범위 라면 예외 처리.")
    @ParameterizedTest
    @CsvSource({"-1", "2", "21", "20000"})
    void inputBridgeLengthByOverSize(int size) {
        assertThatThrownBy(() -> ValidationUtils.size(size))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("게임이 실패 하고 다른 문자가 입력 되는 경우 예외처리.")
    @ParameterizedTest
    @CsvSource({"-1", "r", "다"})
    void inputEndLetterByAnotherLetter(String input) {
        assertThatThrownBy(() -> ValidationUtils.endLetter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}