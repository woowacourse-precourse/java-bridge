package bridge.domain.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import bridge.util.Errors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("다리 길이 입력값 유효성 검사 테스트")
@TestMethodOrder(OrderAnnotation.class)
class BridgeSizeInputValidatorTest {

    private static final BridgeSizeInputValidator sizeInputValidator = new BridgeSizeInputValidator();

    @Order(4)
    @DisplayName("통합 유효성 검사")
    @ParameterizedTest(name = "{displayName} 입력값({index}) : {1}")
    @MethodSource("paramsForTotalValidate")
    void validate(String inputValue, String testOutputMessage) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> sizeInputValidator.validate(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    private static Stream<Arguments> paramsForTotalValidate() {
        return Stream.of(
                Arguments.of("    ", "(공백 값)"),
                Arguments.of("abcd", "abcd"),
                Arguments.of("ㄱㄴㄷㄹ", "ㄱㄴㄷㄹ"),
                Arguments.of("99", "99"),
                Arguments.of("123456", "123456")
        );
    }

    @Order(5)
    @DisplayName("통합 유효성 검사 - 통과 case")
    @ParameterizedTest(name = "{displayName} 입력값({index}) : {0}")
    @ValueSource(strings = {
            "   12",
            "4",
            "20",
            "3"
    })
    void validate(String inputValue) {
        assertThatCode(() -> sizeInputValidator.validate(inputValue)).doesNotThrowAnyException();
        assertThatNoException().isThrownBy(() -> sizeInputValidator.validate(inputValue));

    }

    @Order(1)
    @DisplayName("공백 여부 검사")
    @ParameterizedTest(name = "{displayName} 입력값({index}) : {1}")
    @MethodSource("paramsForBlankTest")
    void validateIsBlank(String inputValue, String testOutputMessage) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> sizeInputValidator.validateIsBlank(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> sizeInputValidator.validateIsBlank(inputValue))
                .withMessage(Errors.IS_EMPTY.message());

    }
    private static Stream<Arguments> paramsForBlankTest() {
        return Stream.of(
                Arguments.of("", "\"\""),
                Arguments.of("\t", "\"\t\""),
                Arguments.of("\n", "개행문자")
        );
    }

    @Order(2)
    @DisplayName("올바른 숫자 값 입력 여부 검사")
    @ParameterizedTest(name = "{displayName} 입력값({index}) : {0}")
    @ValueSource(strings = {
            "abcd",
            "ㄱㄴㄷㄹㅁ",
            "100000000"
    })
    void validateIsInvalid(String inputValue) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> sizeInputValidator.validateIsInvalid(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> sizeInputValidator.validateIsInvalid(inputValue))
                .withMessageContaining("[ERROR]");
    }

    @Order(3)
    @DisplayName("길이 범위 검사")
    @ParameterizedTest(name = "{displayName} 입력값({index}) : {0}")
    @ValueSource(strings = {
            "-1",
            "2",
            "21",
            "99"
    })
    void validateRange(String inputValue) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> sizeInputValidator.validateRange(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> sizeInputValidator.validateRange(inputValue))
                .withMessage(Errors.OUT_OF_BOUND.message());
    }

}