package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @DisplayName("다리 길이 입력 예외 처리 테스트")
    @ValueSource(strings = {"2", "21"})
    @ParameterizedTest
    void checkBridgeSizeTest(Integer input) {
        assertThatThrownBy(() -> new InputView().checkBridgeSize(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력 통과 테스트")
    @ValueSource(strings = {"3", "20"})
    @ParameterizedTest
    void inputBridgeSizeTest(Integer input) {
        assertThatCode(() -> new InputView().checkBridgeSize(input)).doesNotThrowAnyException();
    }

    @DisplayName("이동할 칸 입력 예외 처리 테스트")
    @Test
    void checkMovingTest() {
        assertThatThrownBy(() -> new InputView().checkMoving("A")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸 입력 통과 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void inputMovingTest(String input) {
        assertThatCode(() -> new InputView().checkMoving(input)).doesNotThrowAnyException();
    }

    @DisplayName("재시도 여부 입력 예외 처리 테스트")
    @Test
    void checkGameCommandTest() {
        assertThatThrownBy(() -> new InputView().checkGameCommand("A")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도 여부 입력 통과 테스트")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void inputGameCommandTest(String input) {
        assertThatCode(() -> new InputView().checkGameCommand(input)).doesNotThrowAnyException();
    }
}
