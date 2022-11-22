package bridge;

import bridge.Domain.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {


    @DisplayName("윗 다리 결과 저장 테스트")
    @Test
    public void setUpBridgeResult() {
        final GameResult gameResult = new GameResult();
        gameResult.setUpBridge("U", false);
        gameResult.setUpBridge("D", false);
        gameResult.setUpBridge("U", true);
        List<String> expectResult = List.of("O", " ", "X");
        assertThat(gameResult.getUpBridge()).isEqualTo(expectResult);
    }

    @DisplayName("아레 다리 결과 저장 테스트")
    @Test
    public void setDownBridgeResult() {
        final GameResult gameResult = new GameResult();
        gameResult.setDownBridge("D", false);
        gameResult.setDownBridge("D", true);
        gameResult.setDownBridge("U", true);
        List<String> expectResult = List.of("O", "X", " ");
        assertThat(gameResult.getDownBridge()).isEqualTo(expectResult);
    }

}
