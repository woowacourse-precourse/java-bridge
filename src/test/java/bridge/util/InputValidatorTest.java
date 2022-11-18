package bridge.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("다리 길이는 숫자이다.")
    @ParameterizedTest
    @CsvSource({"3,true", "17a,false", "aa,false"})
    void 다리_길이가_숫자인지_테스트(String number, Boolean expected) {
        assertThat(inputValidator.isNumber(number)).isEqualTo(expected);
    }

    @DisplayName("다리 길이는 3 이상 20 이하이다.")
    @ParameterizedTest
    @CsvSource({"2,false", "3,true", "21,false"})
    void 다리_길이_범위_테스트(int size, Boolean expected) {
        assertThat(inputValidator.isRangeSize(size)).isEqualTo(expected);
    }


    @DisplayName("다리 길이가 유효하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"2", "-1", "22"})
    void 다리_길이_범위_테스트(String bridgeSize) {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

}