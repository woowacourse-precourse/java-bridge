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

    @DisplayName("입력 횟수에 따라 재시작이 정상적으로 실행된다.")
    @Test
    void retryGame() {
        BridgeGame bridgeGame = new BridgeGame(SIZE);
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.retry();

        assertThat(bridgeGame.getTryCount()).isEqualTo(3);
        assertThat(bridgeGame.getInputBridge().size()).isEqualTo(0);
    }

    @DisplayName("사용자 입력 리스트에 따라 성공 여부를 알맞게 반환한다.")
    @Test
    void checkSuccess() {
        BridgeGame bridgeGame = new BridgeGame(SIZE);
        bridgeGame.move(bridgeGame.getBridge().get(0));
        bridgeGame.move(bridgeGame.getBridge().get(1));
        assertThat(bridgeGame.isSuccess()).isEqualTo(false);
        bridgeGame.move(bridgeGame.getBridge().get(2));
        bridgeGame.move(bridgeGame.getBridge().get(3));
        bridgeGame.move(bridgeGame.getBridge().get(4));
        assertThat(bridgeGame.isSuccess()).isEqualTo(true);
    }

    @DisplayName("사용자가 다리를 올바르게 건너고 있는지 확인한다.")
    @Test
    void checkRightStep() {
        BridgeGame bridgeGame = new BridgeGame(SIZE);
        String step = "U";
        if (bridgeGame.getBridge().get(1).equals("U")) {
            step = "D";
        }
        bridgeGame.move(bridgeGame.getBridge().get(0));
        bridgeGame.move(bridgeGame.getBridge().get(1));
        assertThat(bridgeGame.isRightStep()).isEqualTo(true);
        bridgeGame.move(step);
        assertThat(bridgeGame.isRightStep()).isEqualTo(false);
    }

}