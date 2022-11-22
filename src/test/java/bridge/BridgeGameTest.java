package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    private static final int SIZE = 5;

    @DisplayName("틀린 글자로 move 메서드를 실행하면 예외가 발생한다.")
    @Test
    void moveWithWrongInput() {
        BridgeGame bridgeGame = new BridgeGame(SIZE);
        assertThatThrownBy(() -> bridgeGame.move("Q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 움직임이 리스트에 순서대로 저장된다.")
    @Test
    void moveWithRightOrder() {
        BridgeGame bridgeGame = new BridgeGame(SIZE);
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");

        assertThat(bridgeGame.getInputBridge())
                .isEqualTo(List.of("U", "U", "D"));
    }

}