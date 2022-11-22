package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserBridgeTest {

    @DisplayName("현재까지 이동한 Index 값을 반환")
    @Test
    void 현재_이동_위치_반환() {
        UserBridge userBridge = new UserBridge();

        userBridge.add("U");
        userBridge.add("U");
        userBridge.add("D");

        assertThat(userBridge.getCurrentIndex()).isEqualTo(2);
    }

    @DisplayName("다리 끝까지 도착한 경우")
    @Test
    void 성공_테스트() {
        Bridge bridge = new Bridge(Arrays.asList("U","U","D"));
        UserBridge userBridge = new UserBridge();

        userBridge.add("U");
        userBridge.add("U");
        userBridge.add("D");

        assertThat(userBridge.isArrive(bridge)).isEqualTo(true);
    }

    @DisplayName("다리 이동에 실패한 경우")
    @Test
    void 실패_테스트() {
        Bridge bridge = new Bridge(Arrays.asList("U","U","D"));
        UserBridge userBridge = new UserBridge();

        userBridge.add("U");
        userBridge.add("D");
        userBridge.add("D");

        assertThat(userBridge.isArrive(bridge)).isEqualTo(false);
    }

    @DisplayName("현재까지 이동한 Index 값을 반환")
    @Test
    void 초기화_테스트() {
        UserBridge userBridge = new UserBridge();

        userBridge.add("U");
        userBridge.add("U");
        userBridge.add("D");

        assertThat(userBridge.getCurrentIndex()).isEqualTo(2);
    }
    
}