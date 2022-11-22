package bridge.domain.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

@DisplayName("이동 방향 입력 값 유효성 검사 테스트")
@TestMethodOrder(OrderAnnotation.class)
class MovingInputValidatorTest {
    private static final MovingInputValidator movingInputValidator = new MovingInputValidator();

    @Order(4)
    @DisplayName("통합 유효성 검사")
    @ParameterizedTest(name = "{displayName} 입력값({index}) : {1}")
    @MethodSource("paramsForTotalValidate")
    void validate(String inputValue, String testOutputMessage) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> movingInputValidator.validate(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    private static Stream<Arguments> paramsForTotalValidate() {
        return Stream.of(
                Arguments.of("    ", "(공백 값)"),
                Arguments.of("abcd", "abcd"),
                Arguments.of("1234", "1234"),
                Arguments.of("u", "u"),
                Arguments.of("Q", "Q"),
                Arguments.of("R", "R"),
                Arguments.of("d", "d")
        );
    }

    @Order(5)
    @DisplayName("통합 유효성 검사 - 통과 case")
    @ParameterizedTest(name = "{displayName} 입력값({index}) : {0}")
    @ValueSource(strings = {
            "U",
            "D"
    })
    void validate(String inputValue) {
        assertThatCode(() -> movingInputValidator.validate(inputValue)).doesNotThrowAnyException();
        assertThatNoException().isThrownBy(() -> movingInputValidator.validate(inputValue));
    }

    @Order(1)
    @DisplayName("공백 여부 검사")
    @ParameterizedTest(name = "{displayName} 입력값({index}) : {1}")
    @MethodSource("paramsForBlankTest")
    void validateIsBlank(String inputValue, String testOutputMessage) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> movingInputValidator.validateIsBlank(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> movingInputValidator.validateIsBlank(inputValue))
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
    @DisplayName("알파벳 u/d 값 입력 여부 검사")
    @ParameterizedTest(name = "{displayName} 입력값({index}) : {0}")
    @ValueSource(strings = {
            "123",
            "a",
            "   r",
            "q",
            "Q"
    })
    void validateIsInvalid(String inputValue) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> movingInputValidator.validateIsInvalid(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> movingInputValidator.validateIsInvalid(inputValue))
                .withMessage(Errors.INVALID_MOVE_VALUE.message());
    }

    @Order(3)
    @DisplayName("대문자 U/D 값 입력 여부 검사")
    @ParameterizedTest(name = "{displayName} 입력값({index}) : {0}")
    @ValueSource(strings = {
            "u",
            "d",
    })
    void validateRange(String inputValue) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> movingInputValidator.validateIsUpperCase(inputValue))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> movingInputValidator.validateIsUpperCase(inputValue))
                .withMessage(Errors.NOT_UPPERCASE.message());
    }
}