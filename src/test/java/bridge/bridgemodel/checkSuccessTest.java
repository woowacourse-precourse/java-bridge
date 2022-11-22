package bridge.bridgemodel;

import bridge.Bridge;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class checkSuccessTest {

    @Test
    void 성공_기능_테스트() {
        Bridge rightBridge = new Bridge(List.of(new String[]{"U", "D", "U"}));
        Bridge userBridge = new Bridge(List.of(new String[]{"U", "D", "U"}));

        boolean success = rightBridge.checkSuccess(userBridge);
        assertThat(success).isEqualTo(true);
    }

    @Test
    void 실패_기능_테스트() {
        Bridge rightBridge = new Bridge(List.of(new String[]{"U", "D", "U"}));
        Bridge userBridge = new Bridge(List.of(new String[]{"U", "U", "U"}));

        boolean success = rightBridge.checkSuccess(userBridge);
        assertThat(success).isEqualTo(false);
    }

    @Test
    void 크기_실패_기능_테스트() {
        Bridge rightBridge = new Bridge(List.of(new String[]{"U", "D", "U"}));
        Bridge userBridge = new Bridge(List.of(new String[]{"U", "U"}));

        boolean success = rightBridge.checkSuccess(userBridge);
        assertThat(success).isEqualTo(false);
    }
}