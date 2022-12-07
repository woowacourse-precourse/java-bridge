package bridge.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgePositionTest {

    BridgePosition bridgeFirst;
    BridgePosition bridgeSecond;
    BridgePosition bridgeFinal;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridgeFirst = new BridgePosition(bridge);
        bridgeSecond = new BridgePosition(bridge);
        bridgeFinal = new BridgePosition(bridge);

        bridgeFirst.addCurrentRoundNumber();
        bridgeSecond.addCurrentRoundNumber();
        bridgeFinal.addCurrentRoundNumber();
        bridgeFinal.addCurrentRoundNumber();
        bridgeFinal.addCurrentRoundNumber();
    }

    @AfterEach
    void afterEach() {
        bridgeFirst = null;
        bridgeSecond = null;
        bridgeFinal = null;
    }

    @DisplayName("이동이 실패하는 지 반환한다.")
    @Test
    void isFailTest() {
        Boolean isRecordFirstFail = bridgeFirst.isFail("D");
        Boolean isRecordSecondFail = bridgeSecond.isFail("U");

        assertThat(isRecordFirstFail).isTrue();
        assertThat(isRecordSecondFail).isFalse();
    }
}