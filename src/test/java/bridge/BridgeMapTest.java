package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMapTest {

    @DisplayName("update 메서드는 bridgeGame의 상태에 따라 선택된 row에 O 또는 X 표시를 한다.")
    @Test
    void update() {
        BridgeMap bridgeMap = new BridgeMap();

        bridgeMap.update("U", BridgeGameState.NORMAL);
        bridgeMap.update("D", BridgeGameState.GAME_OVER);

        List<String> upperRow = bridgeMap.getUpperRow();
        List<String> lowerRow = bridgeMap.getLowerRow();
        assertThat(upperRow).isEqualTo(List.of("O", " "));
        assertThat(lowerRow).isEqualTo(List.of(" ", "X"));
    }
}
