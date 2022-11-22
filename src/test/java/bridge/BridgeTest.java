package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    Bridge bridge;

    @BeforeEach
    void makeBridge() {
        bridge = new Bridge(List.of("U","U","D","U","D"));
    }

    @DisplayName("compare한 후에 원소가 추가된 results 배열이 기댓값과 같은지 확인")
    @Test
    void compareWithBridgeTest() {
        bridge.compareWithBridge("U");
        bridge.compareWithBridge("U");
        bridge.compareWithBridge("D");
        bridge.compareWithBridge("U");
        bridge.compareWithBridge("U");
        Assertions.assertThat(bridge.getResults()).containsExactly(true, true, true, true, false);
    }

    @DisplayName("results배열에 false가 있는지를 반환하는 메서드 테스트")
    @Test
    void isFalseInResultTest1() {
        setResults1();
        Assertions.assertThat(bridge.isFalseInResults()).isEqualTo(true);
    }

    @DisplayName("results배열에 false가 있는지를 반환하는 메서드 테스트")
    @Test
    void isFalseInResultTest2() {
        setResults2();
        Assertions.assertThat(bridge.isFalseInResults()).isEqualTo(false);
    }

    private void setResults1() {
        bridge.compareWithBridge("U");
        bridge.compareWithBridge("U");
        bridge.compareWithBridge("D");
        bridge.compareWithBridge("U");
        bridge.compareWithBridge("U");
    }
    private void setResults2() {
        bridge.compareWithBridge("U");
        bridge.compareWithBridge("U");
        bridge.compareWithBridge("D");
        bridge.compareWithBridge("U");
        bridge.compareWithBridge("D");
    }

    @DisplayName("restart시, results배열이 잘 비워지는지 확인")
    @Test
    void restartBridge() {
        setResults1();
        Assertions.assertThat(bridge.getResults().size()).isEqualTo(5);
        bridge.restartBridge();
        Assertions.assertThat(bridge.getResults().size()).isEqualTo(0);
    }

    @DisplayName("plusTryCount시, tryCount에 1이 잘 더해지는지 확인")
    @Test
    void plusTryCountTest() {
        bridge.plusTryCount();
        Assertions.assertThat(bridge.getTryCount()).isEqualTo(2);
    }
    
}