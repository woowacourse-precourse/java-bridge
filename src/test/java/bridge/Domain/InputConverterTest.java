package bridge.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputConverterTest {
    @DisplayName("정상적인 값의 문자열을 정수로 변환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1", "5", "4", "10"})
    void 문자열을_정수로_변환(String input) {
        int convertedNumber = InputConverter.convertToInt(input);
        int expectedNumber = Integer.parseInt(input);

        assertThat(convertedNumber).isEqualTo(expectedNumber);
    }

    @DisplayName("잘못된 입력값이 예외를 던지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "1a", "1,0"})
    void 예외_정수_변환(String input) {
        assertThatThrownBy(() ->
                InputConverter.convertToInt((input)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}