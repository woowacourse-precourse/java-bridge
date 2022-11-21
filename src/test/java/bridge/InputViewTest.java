package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class InputViewTest {
    private final InputView inputView = new InputView();

    @ParameterizedTest
    @ValueSource(strings = {"3", "10", "20"})
    @DisplayName("다리 길이 입력값이 정상일 때 숫자로 변환된 값을 반환하는지 확인한다.")
    void readBridgeSize(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        Assertions.assertThat(inputView.readBridgeSize()).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "21"})
    @DisplayName("다리 길이 입력값이 범위를 벗어났을 때 예외가 발생하는지 확인한다.")
    void readBridgeSizeByBoundOutNumber(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        Assertions.assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "ABC", "가나다"})
    @DisplayName("다리 길이 입력값의 포맷이 비정상일 때 예외가 발생하는지 확인한다.")
    void readBridgeSizeByInvalidInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        Assertions.assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    @DisplayName("다리의 다음 칸으로 이동하기 위한 입력값이 정상일 때 문자열을 반환하는지 확인한다.")
    void readMoving(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        Assertions.assertThat(inputView.readMoving()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"L", "100", "UD"})
    @DisplayName("다리의 다음 칸으로 이동하기 위한 입력값이 비정일 때 예외가 발생하는지 확인한다.")
    void readMovingByInvalidString(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        Assertions.assertThatThrownBy(inputView::readMoving)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
