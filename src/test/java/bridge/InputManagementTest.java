package bridge;

import static bridge.constant.ErrorMessage.INPUT_BRIDGE_SIZE_ERROR;
import static bridge.constant.ErrorMessage.INPUT_DIRECTION_ERROR;
import static bridge.constant.ErrorMessage.INPUT_RETRY_OR_QUIT_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputManagementTest {
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

    @DisplayName("양의 정수가 아닌 다리 길이 예외 처리")
    @ValueSource(strings = {".0", "test", "1 3", "4.1", "-14", " 5 1"})
    @ParameterizedTest
    @EmptySource
    void notValidBridgeSize(String input) {
        InputManagement inputManagement = new InputManagement(input);
        assertThatThrownBy(() -> inputManagement.isNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(INPUT_BRIDGE_SIZE_ERROR));
    }

    @DisplayName("U, D 아닌 이동 방향 예외 처리")
    @ValueSource(strings = {"A", "U1", "Ua", ".D"})
    @ParameterizedTest
    @EmptySource
    void notValidDirection(String input) {
        InputManagement inputManagement = new InputManagement(input);
        assertThatThrownBy(() -> inputManagement.isUpOrDown())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(INPUT_DIRECTION_ERROR));
    }

    @DisplayName("R, Q 아닌 재시작/종료 예외 처리")
    @ValueSource(strings = {"A", "r", "q", "R."})
    @ParameterizedTest
    @EmptySource
    void notRetryOrQuit(String input) {
        InputManagement inputManagement = new InputManagement(input);
        assertThatThrownBy(() -> inputManagement.isRetryOrQuit())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(INPUT_RETRY_OR_QUIT_ERROR));
    }
}
