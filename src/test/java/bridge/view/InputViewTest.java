package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static bridge.view.InputView.*;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    private final InputView inputView = new InputView();

    @DisplayName("다리 길이로 정수 아닌 수 또는 문자 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"12j", " ", "abc", "a123e", "-3.5", "1.23", "1,000"})
    public void readBridgeSizeNumberFormatExceptionTest(String bridgeSize) {
        final byte[] buf = String.join("\n", bridgeSize).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_BRIDGE_SIZE_ONLY_INTEGER);
    }

    @DisplayName("다리 길이로 3 ~ 20 이외의 정수 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2", "21", "0", "-3", "-11"})
    public void readBridgeSizeRangeExceptionTest(String bridgeSize) {
        final byte[] buf = String.join("\n", bridgeSize).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_BRIDGE_SIZE_RANGE);
    }

    @DisplayName("이동할 칸으로 U 또는 D 이외의 문자 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "UD", " ", "abcde"})
    public void readMovingExceptionTest(String moving) {
        final byte[] buf = String.join("\n", moving).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(inputView::readMoving)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_MOVING);
    }

    @DisplayName("게임 재시도 여부로 R 또는 Q 이외의 문자 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "RQ", " ", "fghij"})
    public void readGameCommandExceptionTest(String gameCommand) {
        final byte[] buf = String.join("\n", gameCommand).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(inputView::readGameCommand)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_GAME_COMMAND);
    }
}
