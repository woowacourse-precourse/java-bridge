package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    private InputView iv = new InputView();

    @Test
    void convertBridgeSize_동작_테스트() {
        assertThat(iv.convertBridgeSize("3")).isEqualTo(3);
    }

    @ValueSource(strings = {"3d", " _5", "0", "-1", "21"})
    @ParameterizedTest
    void convertBridgeSize_에러_테스트(String input) {
        assertThatThrownBy(() -> iv.convertBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void convertMoving_동작_테스트() {
        assertThat(iv.convertMoving("U")).isEqualTo("U");
    }

    @Test
    void convertMoving_동작_테스트_2() {
        assertThat(iv.convertMoving("D")).isEqualTo("D");
    }

    @ValueSource(strings = {"3", "Q", "UD"})
    @ParameterizedTest
    void convertMoving_에러_테스트(String input) {
        assertThatThrownBy(() -> iv.convertMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void convertGameCommand_동작_테스트() {
        assertThat(iv.convertGameCommand("Q")).isEqualTo("Q");
    }

    @Test
    void convertGameCommand_동작_테스트_2() {
        assertThat(iv.convertGameCommand("R")).isEqualTo("R");
    }

    @ValueSource(strings = {"3", "U", "QR"})
    @ParameterizedTest
    void convertGameCommand_에러_테스트(String input) {
        assertThatThrownBy(() -> iv.convertGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
