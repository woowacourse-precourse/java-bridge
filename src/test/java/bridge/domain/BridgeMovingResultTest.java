package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMovingResultTest {
    private List<String> bridgeInfo;

    @BeforeEach
    void setUp() {
        bridgeInfo = new ArrayList<>(List.of("U", "D", "U", "D", "D"));
    }

    @Test
    @DisplayName("다리 이동 객체가 정상적으로 생성되어야 합니다.")
    void createBridgeMovingResultTest() {
        assertThat(new BridgeMovingResult(bridgeInfo))
                .isInstanceOf(BridgeMovingResult.class);
    }

    @Test
    @DisplayName("다리를 건너면 다리 정보가 업데이트 되어야 합니다.")
    void updatePlayingMapTest() {
        BridgeMovingResult bridgeMovingResult = new BridgeMovingResult(bridgeInfo);
        bridgeMovingResult.updatePlayingMap(List.of("U"), 0);
        assertThat(bridgeMovingResult.getPlayingMap())
                .isEqualTo(List.of(List.of("O"), List.of(" ")));
    }

    @Test
    @DisplayName("재시작 시 다리 정보가 초기화 되어야 합니다.")
    void initializePlayingMapTest() {
        BridgeMovingResult bridgeMovingResult = new BridgeMovingResult(bridgeInfo);
        bridgeMovingResult.updatePlayingMap(List.of("U"), 0);
        bridgeMovingResult.initialize();
        assertThat(bridgeMovingResult.getPlayingMap())
                .isEqualTo(List.of(List.of(), List.of()));
    }
}