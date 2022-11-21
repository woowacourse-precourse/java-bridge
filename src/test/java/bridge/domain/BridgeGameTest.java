package bridge.domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {
    private final String UP = Direction.UP.getCommand();
    private final String DOWN = Direction.DOWN.getCommand();
    @DisplayName("현재까지 건넌 다리를 정확하게 리턴하는지 확인한다.")
    @Test
    void testGetCurrentMap() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setBridge(List.of(UP, UP, DOWN));
        bridgeGame.move(UP);
        bridgeGame.move(DOWN);
        String[][] result = {{"O", " "}, {" ", "X"}};
        assertThat(isEqual(result, bridgeGame.getCurrentMap())).isEqualTo(true);
    }

    @DisplayName("게임이 아직 시작되지 않았을 때 게임 진행에 관련 된 메소드를 실행하면 예외 처리 한다.")
    @Test
    void playGameWithoutBridge() {
         BridgeGame bridgeGame = new BridgeGame();
         assertThatThrownBy(() -> bridgeGame.move(UP))
                 .isInstanceOf(IllegalStateException.class);
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