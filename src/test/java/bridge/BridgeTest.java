package bridge;

import bridge.domain.Bridge;
import bridge.setting.Setting;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BridgeTest {

    Bridge bridge = new Bridge(Arrays.asList("U", "D", "U", "D"));

    @Test
    void getBridgeSizeTest() {
        assertEquals(4, bridge.getBridgeSize());
    }

    @DisplayName("첫번째 다리 건넘 + 틀렸을 경우")
    @Test
    void myBridgeTestOneRound() {
        assertEquals(Arrays.asList(" ", "X"), bridge.myBridge(1, false));
    }

    @DisplayName("모든 다리를 건넘 + 틀렸을 경우")
    @Test
    void myBridgeTestAllRound() {
        assertEquals(Arrays.asList("O |   | O | X", "  | O |   |  "), bridge.myBridge(4, false));
    }

    @DisplayName("다리 길이를 벗어난 입력값이 들어올 경우, 예외나는지 확인")
    @Test
    void myBridgeTestException() {
        assertThatThrownBy(() -> bridge.myBridge(5, false))
                .isInstanceOf(Exception.class);
    }

    @DisplayName("첫번째 인덱스와 U 동일한지 확인")
    @Test
    void isCorrectTest() {
        assertEquals(true, bridge.isCorrect(1, Setting.PLAYER_MOVE_UP));
    }

    @DisplayName("인덱스를 넘어갈 경우 예외가 나는지 확인")
    @Test
    void isCorrectTestException() {
        assertThatThrownBy(() -> bridge.isCorrect(0, Setting.PLAYER_MOVE_UP))
                .isInstanceOf(Exception.class);
    }
}
