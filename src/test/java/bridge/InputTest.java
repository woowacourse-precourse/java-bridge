package bridge;

import domain.AllBridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @DisplayName("다리 길이로 문자가 입력되었을때")
    @Test
    void 다리길이_문자입력() {
        String testLength = "1a";
        AllBridge allBridge = new AllBridge();

        assertThatThrownBy(() ->allBridge.checkBridgeLength(testLength))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이로 2가 입력되었을 때")
    @Test
    void 다리길이_2_입력() {
        String testLength = "2";
        AllBridge allBridge = new AllBridge();

        assertThatThrownBy(() ->allBridge.checkBridgeLength(testLength))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이로 21이 입력되었을 때")
    @Test
    void 다리길이_21_입력() {
        String testLength = "21";
        AllBridge allBridge = new AllBridge();

        assertThatThrownBy(() ->allBridge.checkBridgeLength(testLength))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
