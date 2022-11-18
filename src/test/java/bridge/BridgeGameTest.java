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
        assertThat(bridgeGame.move("U")).isEqualTo(List.of("U", "O"));
        assertThat(bridgeGame.move("D")).isEqualTo(List.of("U", "D", "O"));
        assertThat(bridgeGame.move("U")).isEqualTo(List.of("U", "D", "U", "X"));
    }

    @DisplayName("잘못된 입력값인 경우")
    @Test
    void moveByInvaildInput() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThatThrownBy(
                () -> bridgeGame.move("u")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("종료 재시작 선택 시 잘못된 입력값인 경우")
    @Test
    void commandByInvaildInput() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        ;
        assertThatThrownBy(
                () -> bridgeGame.retry("q")).isInstanceOf(IllegalArgumentException.class);
    }
}