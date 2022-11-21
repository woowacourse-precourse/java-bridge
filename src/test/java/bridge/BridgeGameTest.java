package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();
    List<String> bridge = Arrays.asList("U","U","D");

    @DisplayName("메소드 move 테스트")
    @Test
    void move() {
        bridgeGame.move(bridge,"U");
        assertThat(bridgeGame.getPlayerLocationIndex()).isEqualTo(0);
    }

    @DisplayName("메소드 checkAnswer해서 맞았을 경우 테스트")
    @Test
    void checkAnswer_right() {
        bridgeGame.move(bridge,"U");
        assertThat(bridgeGame.getUpMap().get(bridgeGame.getPlayerLocationIndex())).isEqualTo("O");
    }

    @DisplayName("메소드 checkAnswer해서 틀렸을 경우 테스트")
    @Test
    void checkAnswer_wrong() {
        bridgeGame.move(bridge,"D");
        assertThat(bridgeGame.getDownMap().get(bridgeGame.getPlayerLocationIndex())).isEqualTo("X");
    }

    @DisplayName("메소드 updateMap 테스트")
    @Test
    void updateMap() {
        bridgeGame.move(bridge,"U");
        bridgeGame.move(bridge,"U");
        assertThat(bridgeGame.getUpMap().size()).isEqualTo(2);
    }


}