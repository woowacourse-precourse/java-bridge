package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    @DisplayName("현재까지 건넌 다리를 정확하게 리턴하는지 확인한다.")
    @Test
    void TestGetCurrentMap() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setBridge(List.of("U", "U", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        String[][] result = {{"O", " "}, {" ", "X"}};
        assertThat(isEqual(result, bridgeGame.getCurrentMap())).isEqualTo(true);
    }

    private boolean isEqual(String[][] map1, String[][] map2) {
        if (map1.length != map2.length || map1[0].length != map2[0].length) return false;
        for (int x = 0; x < map1.length; x++) {
            for (int y = 0; y < map1[x].length; y++) {
                if (map1[x][y] != map2[x][y]) return false;
            }
        }
        return true;
    }
}