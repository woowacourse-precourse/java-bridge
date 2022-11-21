package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    public void initialize() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("이동 가능한 칸일 경우 이동하는지 테스트")
    @Test
    public void addOWhenEqualTest() {
        String movingCommand = "U";
        String currBox = "U";
        bridgeGame.addOWhenEqual(movingCommand, currBox);

        List<String> bridgeCurrStatus = bridgeGame.getBridgeCurrStatus();
        assertThat(bridgeCurrStatus).isEqualTo(List.of("O"));
    }
}
