package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class UtilTest {

    public static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("숫자인지 아닌지 검사하는 테스트 코드")
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "a, false"
    })
    void isNumberTest(String input, boolean isSuccess) {
        boolean isTrue = Util.isNumber(input);

        assertThat(isTrue)
                .isEqualTo(isSuccess);
    }

    @DisplayName("문자인지 아닌지 검사하는 테스트 코드")
    @ParameterizedTest
    @CsvSource({
            "a, true",
            "1, false"
    })
    void isLetterTest(String input, boolean isSuccess) {
        boolean isTrue = Util.isLetter(input);

        assertThat(isTrue)
                .isEqualTo(isSuccess);
    }

    @DisplayName("한 글자인지 아닌지 검사하는 테스트 코드")
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "aa, false",
            "'', false"
    })
    void isOneLetterTest(String input, boolean isSuccess) {
        boolean isTrue = Util.isOneLetter(input);

        assertThat(isTrue)
                .isEqualTo(isSuccess);
    }


    @DisplayName("여러 글자인지 아닌지 검사하는 테스트 코드")
    @ParameterizedTest
    @CsvSource({
            "1, false",
            "'', false",
            "aa, true"
    })
    void isStringTest(String input, boolean isSuccess) {
            boolean isTrue = Util.isString(input);

            assertThat(isTrue)
                    .isEqualTo(isSuccess);
    }

    @DisplayName("1입력시 U, 0입력시 D 리턴 테스트 코드")
    @ParameterizedTest
    @CsvSource({
            "1, U",
            "0, D"
    })
    void convertBridgeNumberGeneratorTest(int input, String bridgeValue) {
        {
            assertThat(Util.convertBridgeNumberGenerator(input))
                    .isEqualTo(bridgeValue);
        }
    }

    @DisplayName("숫자열을 정수로 바꿔준다. 범위는 1~20이 최대다")
    @ParameterizedTest
    @ValueSource(strings={"0", "-1", "111222333444555666777888999000", "010"})
    void stringToIntegerTest() {
        assertThatThrownBy(() ->
                Util.stringToInteger("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}