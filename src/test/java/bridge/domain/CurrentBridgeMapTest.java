package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CurrentBridgeMapTest {
    private CurrentBridgeMap currentBridgeMap;

    @BeforeEach
    void initTest() {
        currentBridgeMap = new CurrentBridgeMap();
    }

    @DisplayName("길이가 3이고, 마지막이 실패인 다리 그림")
    @Test
    void checkFailBridge() {
        List<String> playerMoves = Arrays.asList("U", "D", "D");
        List<Boolean> equalAnswer = Arrays.asList(true, true, false);
        String result = "";
        String expect = "[ O |   |   ]\n[   | O | X ]";

        for (int i = 0; i < playerMoves.size(); i++) {
            result = currentBridgeMap
                    .getCurrentBridgeMap(playerMoves.get(i), equalAnswer.get(i));
        }

        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("길이가 3이고, 마지막이 성공인 다리 그림")
    @Test
    void checkSuccessBridgeLength() {
        List<String> playerMoves = Arrays.asList("U", "D", "D");
        List<Boolean> equalAnswer = Arrays.asList(true, true, true);
        String result = "";
        String expect = "[ O |   |   ]\n[   | O | O ]";

        for (int i = 0; i < playerMoves.size(); i++) {
            result = currentBridgeMap
                    .getCurrentBridgeMap(playerMoves.get(i), equalAnswer.get(i));
        }

        assertThat(result).isEqualTo(expect);
    }
}
