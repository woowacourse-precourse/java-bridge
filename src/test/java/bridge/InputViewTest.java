package bridge;

import bridge.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    private static final InputView inputView = new InputView();

    @DisplayName("다리 사이즈를 입력받아서 반환")
    @Test
    void inputBridgeSize() {
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        assertThat(inputView.readBridgeSize()).isEqualTo(3);
    }

    @DisplayName("잘못된 다리 사이즈를 입력받은 경우 예외 반환")
    @ValueSource(strings = {"03", "21", "3j"})
    @ParameterizedTest
    void inputBridgeSizeException(String input) {
        runException(input);
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("건널 다리의 위치를 입력받아서 반환")
    @Test
    void inputBridgeMoving() {
        System.setIn(new ByteArrayInputStream("U".getBytes()));
        String result = "U";
        assertThat(inputView.readMoving()).isEqualTo(result);
    }

    @DisplayName("잘못된 위치를 입력받으면 예외 반환")
    @ValueSource(strings = {"u", "d", "D3"})
    @ParameterizedTest
    void inputBridgeMovingException(String input) {
        runException("3", input);
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("재시작 여부를 입력받아서 반환")
    @Test
    void inputGameCommand() {
        System.setIn(new ByteArrayInputStream("R".getBytes()));
        assertThat(inputView.readGameCommand()).isEqualTo("R");
    }

    @DisplayName("잘못된 재시작 여부를 입력받으면 예외 반환")
    @ValueSource(strings = {"r", "q", "R3"})
    @ParameterizedTest
    void inputGameCommandException(String input) {
        runException("3", "U", input);
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @Override
    protected void runMain() {
        inputView.readBridgeSize();
        inputView.readMoving();
        inputView.readGameCommand();
    }
}
