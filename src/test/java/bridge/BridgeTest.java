package bridge;

import bridge.domain.Bridge;
import bridge.domain.MoveIndicator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {
    @DisplayName("사용자가 갈 수 있는 방향을 입력한 경우에 대한 테스트")
    @Test
    void successBuildSubBridgeTest() {
        String userDirection = "U";
        String accessibleDirection = "U";
        Bridge bridge = new Bridge(MoveIndicator.UP);
        String expected = "[ O ]";

        assertEquals(expected,
                bridge.buildSubBridge(userDirection, accessibleDirection));
    }

    @DisplayName("사용자가 갈 수 없는 방향을 입력한 경우에 대한 테스트")
    @Test
    void failureBuildSubBridgeTest() {
        String userDirection = "U";
        String accessibleDirection = "D";
        Bridge bridge = new Bridge(MoveIndicator.UP);
        String expected = "[ X ]";

        assertEquals(expected,
                bridge.buildSubBridge(userDirection, accessibleDirection));
    }
}
