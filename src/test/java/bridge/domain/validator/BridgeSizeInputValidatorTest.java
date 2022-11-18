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

@DisplayName("다리 길이 입력값 유효성 검사 테스트")
@TestMethodOrder(OrderAnnotation.class)
class BridgeSizeInputValidatorTest {

    private static final  BridgeSizeInputValidator sizeInputValidator  = new BridgeSizeInputValidator();

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


}