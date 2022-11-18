package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    @DisplayName("올바른 칸 이동")
    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThat(bridgeGame.move("U")).isEqualTo(true);
        assertThat(bridgeGame.move("D")).isEqualTo(true);
        assertThat(bridgeGame.move("D")).isEqualTo(true);
    }

    @DisplayName("잘못된 입력값인 경우")
    @Test
    void moveByInvaildInput() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThatThrownBy(
                () -> bridgeGame.move("u")).isInstanceOf(IllegalArgumentException.class);
    }

}
