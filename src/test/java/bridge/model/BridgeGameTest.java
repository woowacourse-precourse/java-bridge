package bridge.model;

import bridge.model.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeGameTest {
    static BridgeGame bridgeGame = new BridgeGame();

    @Test
    @DisplayName("move 생성자 Test")
    void case1() {
        String readMoving = "U";
        Move testMove = bridgeGame.moveConstructor(readMoving);
        assertThat(testMove.moveIdx).isEqualTo(0);
        assertThat(testMove.notMoveIdx).isEqualTo(1);
    }
    @Test
    @DisplayName("move 생성자 Test")
    void case2() {
        String readMoving = "P";
        assertThatThrownBy(() -> bridgeGame.moveConstructor(readMoving))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
