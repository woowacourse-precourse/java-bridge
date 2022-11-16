package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
