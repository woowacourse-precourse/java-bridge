package domain;

import bridge.domain.Bridge;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    Bridge bridge;

    @BeforeEach
    @AfterEach
    void clear() {
        bridge = new Bridge();
        bridge.setUpBridge();
        bridge.setDownBridge();
    }

    @DisplayName("윗 다리 성공 테스트")
    @Test
    void createSuccessUpBridge() {
        bridge.succeedUpMovement();
        bridge.replaceUnnecessaryBridge();
        String upBridge = bridge.getUpBridge();
        assertThat(upBridge).isEqualTo("[ O ]");
    }

    @DisplayName("밑 다리 성공 테스트")
    @Test
    void createSuccessDownBridge() {
        bridge.succeedDownMovement();
        bridge.replaceUnnecessaryBridge();
        String downBridge = bridge.getDownBridge();
        assertThat(downBridge).isEqualTo("[ O ]");
    }

    @DisplayName("윗 다리 실패 테스트")
    @Test
    void createFailUpBridge() {
        bridge.failUpMovement();
        bridge.replaceUnnecessaryBridge();
        String upBridge = bridge.getUpBridge();
        assertThat(upBridge).isEqualTo("[ X ]");
    }

    @DisplayName("밑 다리 실패 테스트")
    @Test
    void createFailDownBridge() {
        bridge.failDownMovement();
        bridge.replaceUnnecessaryBridge();
        String downBridge = bridge.getDownBridge();
        assertThat(downBridge).isEqualTo("[ X ]");
    }
}
