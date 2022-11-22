package bridge.domain;

import bridge.BridgeInfo;
import bridge.constant.Token;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    @DisplayName("유저 입력과 결과가 같은지 확인")
    @Test
    void updateCheck() {
        Bridge bridge = new Bridge(List.of("U", "D"));
        assertThat(bridge.update("U")).isEqualTo(true);
        assertThat(bridge.update("U")).isEqualTo(false);
    }

    @DisplayName("위쪽 브릿지에 대한 결과 확인")
    @Test
    void upperBridgeCheck() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        bridge.update("U");
        bridge.update("D");
        bridge.update("U");
        List<BridgeInfo> upperBridge = bridge.getBridgeInfo(Token.UP.getMark());
        assertThat(upperBridge.get(0)).isEqualTo(BridgeInfo.CORRECT);
        assertThat(upperBridge.get(1)).isEqualTo(BridgeInfo.EMPTY);
        assertThat(upperBridge.get(2)).isEqualTo(BridgeInfo.WRONG);
    }

    @DisplayName("아래쪽 브릿지에 대한 결과 확인")
    @Test
    void lowerBridgeCheck() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        bridge.update("U");
        bridge.update("D");
        bridge.update("U");
        List<BridgeInfo> upperBridge = bridge.getBridgeInfo(Token.DOWN.getMark());
        assertThat(upperBridge.get(0)).isEqualTo(BridgeInfo.EMPTY);
        assertThat(upperBridge.get(1)).isEqualTo(BridgeInfo.CORRECT);
        assertThat(upperBridge.get(2)).isEqualTo(BridgeInfo.EMPTY);
    }
}
