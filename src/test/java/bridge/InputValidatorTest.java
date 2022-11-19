package bridge;

import static bridge.constant.ErrorMessage.INPUT_BRIDGE_SIZE_ERROR;
import static bridge.constant.ErrorMessage.INPUT_DIRECTION_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
//    @ParameterizedTest
//    @MethodSource("generateNumber")
//    void shouldGetDataBit(int first, String second, List<String> third) {
//        System.out.println(first);
//        System.out.println(second);
//        System.out.println(third);
//    }
//
//    static Stream<Arguments> generateNumber() {
//        return Stream.of(
//                Arguments.of(1, "foo", Arrays.asList("a", "b", "c")),
//                Arguments.of(2, "bar", Arrays.asList("x", "y", "z"))
//        );
//    }

    @DisplayName("3 ~ 20 범위 숫자가 아닌 다리 길이 입력 예외 처리")
    @ValueSource(strings = {"0", "2", "21", "4.1", "-14"})
    @ParameterizedTest
    @EmptySource
    void notValidBridgeSize(String input) {
        InputValidator inputValidator = new InputValidator(input);
        assertThatThrownBy(() -> inputValidator.isInRangeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(INPUT_BRIDGE_SIZE_ERROR));
    }

    @DisplayName("U, D 아닌 이동 방향 입력 예외 처리")
    @ValueSource(strings = {"A", "U1", "Ua", ".D"})
    @ParameterizedTest
    @EmptySource
    void notValidDirection(String input) {
        InputValidator inputValidator = new InputValidator(input);
        assertThatThrownBy(() -> inputValidator.isUpOrDown())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(INPUT_DIRECTION_ERROR));
    }
}
