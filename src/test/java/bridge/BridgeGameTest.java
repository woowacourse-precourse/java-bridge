package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @Test
    @DisplayName("길이가 3인 다리를 건너는데 성공한다.")
    public void playGame_CrossBridge_Success() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame game = new BridgeGame(bridge);
        boolean result = game.move(PropertyMove.UP);
        result &= game.move(PropertyMove.DOWN);
        result &= game.move(PropertyMove.UP);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("길이가 3인 다리에서 두번째 다리를 건널 때 실패한다.")
    public void playGame_CrossingBridgeAreaTwo_Fail() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame game = new BridgeGame(bridge);
        boolean result = game.move(PropertyMove.UP);
        result &= game.move(PropertyMove.UP);
        assertThat(result).isFalse();
    }
}
