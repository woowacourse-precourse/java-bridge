package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MapMakerTest {
    @DisplayName("성공한 경우 생성된 지도가 올바른 지도인지 검사")
    @Test
    void createMapByAllCorrect() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeStatus(Arrays.asList("U", "D", "D")));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");


        assertThat(bridgeGame.getMap().split("\n")).
                containsOnly("[ O |   |   ]", "[   | O | O ]");
    }

    @DisplayName("실패한 경우 생성된 지도가 올바른 지도인지 검사")
    @Test
    void createMapByNotCorrect() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeStatus(Arrays.asList("U", "D", "D")));
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");


        assertThat(bridgeGame.getMap().split("\n")).
                containsOnly("[   | X |   ]", "[ X |   | O ]");
    }
}
