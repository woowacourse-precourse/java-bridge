package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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

}