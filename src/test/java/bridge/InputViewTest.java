package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

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
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("건널 다리의 위치를 입력받아서 반환")
    @Test
    void inputBridgeMoving() {
        System.setIn(new ByteArrayInputStream("U".getBytes()));
        BridgeLocation result = BridgeLocation.UP;
        assertThat(inputView.readMoving()).isEqualTo(result);
    }

    @DisplayName("잘못된 위치를 입력받으면 예외 반환")
    @ValueSource(strings = {"u", "d", "D3"})
    @ParameterizedTest
    void inputBridgeMovingException(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(inputView::readMoving).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 여부를 입력받아서 반환")
    @Test
    void inputGameCommand() {
        System.setIn(new ByteArrayInputStream("R".getBytes()));
        assertThat(inputView.readGameCommand()).isTrue();
    }

    @DisplayName("잘못된 재시작 여부를 입력받으면 예외 반환")
    @ValueSource(strings = {"r", "q", "R3"})
    @ParameterizedTest
    void inputGameCommandException(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(inputView::readGameCommand).isInstanceOf(IllegalArgumentException.class);
    }
}
