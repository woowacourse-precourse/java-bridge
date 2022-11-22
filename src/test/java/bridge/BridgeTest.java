package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {

    InputView inputView = new InputView();

    @DisplayName("생성할 다리의 길이의 값이 공백일 경우 예외처리 테스트")
    @Test
    void bridgeSizeIsEmpty() {
        String bridgeSize = " ";
        assertThatThrownBy(() -> inputView.checkBridgeSize(bridgeSize)).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("생성할 다리의 길이의 값이 정수형이 아닌 경우 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings={"1r2","5#7","9 7"})
    void bridgeSizeIsNumber(String bridgeSize) {
        assertThatThrownBy(() -> inputView.checkBridgeSize(bridgeSize)).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("생성할 다리의 길이의 값이 3미만, 20 초과일 경우 예외처리 테스트")
    @Test
    void bridgeSizeOutOfRange() {
        String bridgeSize = "25";
        assertThatThrownBy(() -> inputView.checkBridgeSize(bridgeSize)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성할 다리의 길이의 값이 올바를 경우 테스트")
    @Test
    void bridgeSizeCorrect() {
        String bridgeSize = "15";
        assertThat(inputView.checkBridgeSize(bridgeSize)).isEqualTo(15);
    }
}
