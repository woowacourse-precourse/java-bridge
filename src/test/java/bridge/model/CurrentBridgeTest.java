package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CurrentBridgeTest {
    CurrentBridge currentBridge = new CurrentBridge();

    @BeforeEach
    void setUp() {
        currentBridge.saveMap(Stage.judge("U", "U"));
        currentBridge.saveMap(Stage.judge("D", "D"));
    }

    @DisplayName("맞히기만 경우 canNotCross()가 false 반환 테스트")
    @Test
    void success() {
        assertThat(CurrentBridge.canNotCross()).isFalse();
        assertThat(CurrentBridge.getSize()).isEqualTo(2);
    }

    @DisplayName("틀린 경우 canNotCross()가 True 반환 테스트")
    @Test
    void fail() {
        currentBridge.saveMap(Stage.judge("U", "D"));

        assertThat(CurrentBridge.canNotCross()).isTrue();
        assertThat(CurrentBridge.getSize()).isEqualTo(3);
    }

    @DisplayName("틀려서 초기화한 경우 사이즈와 시도 횟수와 결과를 확인하는 테스트")
    @Test
    void retry() {
        currentBridge.saveMap(Stage.judge("U", "D"));
        assertThat(CurrentBridge.canNotCross()).isTrue();
        currentBridge.clearMap();

        assertThat(CurrentBridge.getSize()).isEqualTo(0);
        assertThat(CurrentBridge.getNumberOfAttempts()).isEqualTo(2);
        assertThat(CurrentBridge.getOutcome()).isEqualTo("실패");
    }
}
