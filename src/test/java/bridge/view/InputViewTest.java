package bridge.view;

import static bridge.ErrorMessage.INVALID_BRIDGE_SIZE_ERROR;
import static bridge.ErrorMessage.INVALID_MOVE_DIRECTION_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    private final InputView inputView = new InputView();

    @DisplayName("다리 길이 범위내에 존재하는 값을 입력시 성공한다.")
    @Test
    void readBridgeSizeTest() {
        IntStream.rangeClosed(3, 20)
                .mapToObj(i -> String.valueOf(i))
                .forEach(input -> inputView.validateBridgeSize(input));
    }

    @ParameterizedTest(name = "다리 길이 범위에 벗어나는 {0}를 입력시 예외가 발생힌다.")
    @ValueSource(strings = {"2, 21"})
    void readBridgeSizeExceptionTest(String input) {
        assertThatThrownBy(() -> inputView.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BRIDGE_SIZE_ERROR);
    }

    @ParameterizedTest(name = "이동할 다음 칸을 {0}로 입력하면 성공한다.")
    @ValueSource(strings = {"U", "D"})
    void validateMoveDirectionTest(String input) {
        inputView.validateMoveDirection(input);
    }

    @ParameterizedTest(name = "이동할 다음 칸을 {0}로 잘못 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"A", "UU", "", " ", "d"})
    void validateMoveDirectionExceptionTest(String input) {
        assertThatThrownBy(() -> inputView.validateMoveDirection(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_MOVE_DIRECTION_ERROR);
    }
}