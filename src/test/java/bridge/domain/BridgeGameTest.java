package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @DisplayName("생성자 테스트")
    @Test
    public void BridgeConstructorAndGetterTest() {
        // given
        List<String> list = List.of("U", "D", "D");

        // when
        BridgeGame bridgeGame = new BridgeGame(list);

        // then
        assertThat(bridgeGame.isEndOfIndex()).isEqualTo(false);
        assertThat(bridgeGame.getNowIndex()).isEqualTo(0);
    }

    @DisplayName("resetGame 테스트")
    @Test
    public void resetGameTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move();
        bridgeGame.move();
        bridgeGame.move();

        // when
        bridgeGame.retry();

        // then
        assertThat(bridgeGame.getNowIndex()).isEqualTo(0);
    }

    @DisplayName("move 테스트")
    @Test
    public void nowIndexUpdateTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        // when
        bridgeGame.move();

        // then
        assertThat(bridgeGame.getNowIndex()).isEqualTo(1);
    }

    @DisplayName("isEndOfIndex 테스트")
    @Test
    public void isEndOfIndexTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D", "U", "U"));
        bridgeGame.move();
        bridgeGame.move();
        bridgeGame.move();
        bridgeGame.move();

        // when
        boolean isEndOfIndex = bridgeGame.isEndOfIndex();

        // then
        assertThat(isEndOfIndex).isEqualTo(true);
    }

    @DisplayName("isCorrectMoveDirection 테스트")
    @Test
    public void isCorrectMoveDirectionTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        String moveDirection = "U";

        // when
        boolean result = bridgeGame.isCorrectMoveDirection(moveDirection);

        // then
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("retry 테스트")
    @Test
    public void moveTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move();
        bridgeGame.move();

        // when
        bridgeGame.retry();

        // then
        assertThat(bridgeGame.getNowIndex()).isEqualTo(0);
    }
}
