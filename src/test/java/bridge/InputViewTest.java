package bridge;

import bridge.domain.InputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    @DisplayName("다리 길이 입력값이 3부터 20 사이여야 하는 조건 테스트")
    void validateBridgeSizeTest() {
        InputView inputView = new InputView();
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.readBridgeSize("1a"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.readBridgeSize("123"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.readBridgeSize("21"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.readBridgeSize("2"));
    }
}
