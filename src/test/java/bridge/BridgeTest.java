package bridge;

import bridge.Model.BridgeDTO;
import bridge.Model.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    private final BridgeDTO bridgeDTO = new BridgeDTO();
    private final BridgeGame bridgeGame = new BridgeGame();
    @DisplayName("무브값이 제대로 1씩 늘어나는지 테스트")
    @Test
    void moveTest() {
        for (int i=0;i<3;i++) {
            bridgeGame.move(bridgeDTO);
            assertThat(bridgeDTO.getMovePoint()).isEqualTo(i + 1);
        }
    }

    @DisplayName("retry 할 때 DTO 안에 들어간 값이 제대로 초기화 되는지, retry 횟수가 올라가는지 테스트")
    @Test
    void retryTest() {
        bridgeDTO.setMovePoint(3);
        bridgeDTO.setRetry(1);
        bridgeDTO.getSaveFirstLine().add("O");
        bridgeGame.retry(bridgeDTO);
        assertThat(bridgeDTO.getMovePoint()).isEqualTo(0);
        assertThat(bridgeDTO.getRetry()).isEqualTo(2);
        assertThat(bridgeDTO.getSaveFirstLine().size()).isEqualTo(0);
    }
}
