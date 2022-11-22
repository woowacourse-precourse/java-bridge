package bridge.domain;

import bridge.Validator;
import bridge.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("다리 길이가 3 부터 20 사이일 때, 정상적으로 출력이 되는지")
    @Test
    void bridgeSizeOverThanThreeOrLessThanTwenty() {
        String bridgeSize = "14";
        int size = Integer.parseInt(bridgeSize);

        Assertions.assertThat((size > 2 && size < 21)).isTrue();
    }

    @DisplayName("다리 길이가 3보다 작으면 예외가 발생하는지")
    @Test
    void bridgeSizeLessThanThree() {
        String bridgeSize = "2";

        Assertions.assertThatThrownBy(() -> Validator.validateInputBridgeSizeRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
    }

    @Test
    void retry() {
    }
}

