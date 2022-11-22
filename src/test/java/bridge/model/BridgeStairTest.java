package bridge.model;

import bridge.utils.BridgeGameResultStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("다리의 위, 아래 각 층에 대한 기능 테스트")
class BridgeStairTest {
    private final BridgeStair bridgeStair = new BridgeStair(4);

    @BeforeEach
    void setUp() {
        bridgeStair.addResult(BridgeGameResultStatus.CORRECT);
        bridgeStair.addResult(BridgeGameResultStatus.CORRECT);
        bridgeStair.addResult(BridgeGameResultStatus.CORRECT);
    }

    @Test
    @DisplayName("다리의 끝까지 다 맞춰서 도달한 경우")
    void isGameSuccessTest() {
        bridgeStair.addResult(BridgeGameResultStatus.CORRECT);
        Assertions.assertThat(bridgeStair.isGameSuccess()).isEqualTo(true);
    }

    @Test
    @DisplayName("아직 다리의 끝에 도달하지 못한 경우")
    void isGameSuccessFailTest() {
        Assertions.assertThat(bridgeStair.isGameSuccess()).isEqualTo(false);
    }

    @Test
    @DisplayName("다리의 끝에 도달했지만 마지막 칸에서 오답을 고른 경우")
    void isGameSuccessLastFailTest() {
        bridgeStair.addResult(BridgeGameResultStatus.FAIL);
        Assertions.assertThat(bridgeStair.isGameSuccess()).isEqualTo(false);
    }
}