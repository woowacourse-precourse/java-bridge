package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame(
            new Bridge(Arrays.asList("U", "U", "U", "D")));

    @DisplayName("올바른 칸으로 이동하면 true를 반환한다.")
    @Test
    void moveToValidPath() {
        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(bridgeGame.move("U"))
                    .isEqualTo(true);
        }
        Assertions.assertThat(bridgeGame.move("D"))
                .isEqualTo(true);
    }

    @DisplayName("이동할 수 없는 칸으로 이동하면 false를 반환한다.")
    @Test
    void moveToInvalidPath() {
        Assertions.assertThat(bridgeGame.move("D"))
                .isEqualTo(false);
    }

    @DisplayName("게임 클리어 여부를 확인할 수 있다.")
    @Test
    void clearTheGame() {
        Assertions.assertThat(bridgeGame.isGameClear())
                .isEqualTo(false);
        for (int i = 0; i < 3; i++) {
            bridgeGame.move("U");
        }
        bridgeGame.move("D");

        Assertions.assertThat(bridgeGame.isGameClear())
                .isEqualTo(true);
    }

    @DisplayName("이동 경로를 확인할 수 있다.")
    @Test
    void printMovingPath() {
        for (int i = 0; i < 3; i++) {
            bridgeGame.move("U");
        }

        Assertions.assertThat(bridgeGame.getPath())
                .isEqualTo("[ O | O | O ]\n" +
                        "[   |   |   ]");
    }

}