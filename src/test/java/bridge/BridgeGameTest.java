package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {
    private BridgeGame bridgeGame = new BridgeGame();
    
    @Test
    @DisplayName("결과_참_확인")
    public void trueCheck() {
        boolean actual = bridgeGame.move("U", List.of("U", "D", "U"), 0);
        Assertions.assertThat(actual).isEqualTo(true);
    }
    
    @Test
    @DisplayName("결과_거짓_확인")
    public void falseCheck() {
        boolean actual = bridgeGame.move("D", List.of("U", "D", "U"), 0);
        Assertions.assertThat(actual).isEqualTo(false);
    }
}
