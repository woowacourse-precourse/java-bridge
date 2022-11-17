package bridge.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    private final String ERROR = "[ERROR]";

    @DisplayName("[예외 테스트] 다리길이 입력값이 숫자가 아님")
    @ValueSource(strings = {"a", "1a", "3b", " "})
    @ParameterizedTest
    void bridgeSizeNotANum(String input) {
        //given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when then
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @DisplayName("[예외 테스트] 다리길이 입력값이 범위를 벗어남")
    @ValueSource(strings = {"0", "1", "2", "21", "22"})
    @ParameterizedTest
    void bridgeSizeOutOfRange(String input) {
        //given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when then
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @DisplayName("다리길이 입력 받기")
    @ValueSource(strings = {"3", "4", "7", "15", "20"})
    @ParameterizedTest
    void readBridgeSize(String input) {
        //given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when
        int bridgeSize = inputView.readBridgeSize();
        //then
        assertThat(bridgeSize).isEqualTo(Integer.parseInt(input));
    }
}