package bridge.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    @DisplayName("Player 한칸 이동 성공")
    void move_Success() {
        // Given
        List<String> bridge = List.of("U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);

        // When
        bridgeGame.move("U");

        // Then
        assertThat(bridgeGame.getPlayer().getMovingSpacesSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("Player 이동 불가능하면 false를 반환한다.")
    void isCanCross_Fail() {
        // Given
        List<String> bridge = List.of("U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("D");

        // When
        boolean canCross = bridgeGame.isCanCross();

        // Then
        assertThat(canCross).isFalse();
    }

    @Test
    @DisplayName("게임이 성공하면 true를 반환한다.")
    void isGameSuccess_Success() {
        // Given
        List<String> bridge = List.of("U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        // When
        boolean gameSuccess = bridgeGame.isGameSuccess();

        // Then
        assertThat(gameSuccess).isTrue();
    }

    @Test
    @DisplayName("게임을 재시작 시에 Player의 시도횟수는 하나 증가하고 이동과정의 삭제된다.")
    void retry_Success() {
        // Given
        List<String> bridge = List.of("U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");

        // When
        bridgeGame.retry();

        // Then
        assertThat(bridgeGame.getPlayer().getMovingSpacesSize()).isEqualTo(0);
        assertThat(bridgeGame.getPlayer().getAttempt()).isEqualTo(2);
    }

    @Test
    @DisplayName("게임을 실패시 Player의 isPossible 필드는 false이다.")
    void failGame_Success() {
        // Given
        List<String> bridge = List.of("U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");

        // When
        bridgeGame.failGame();

        // Then
        assertThat(bridgeGame.getPlayer().isPossible()).isFalse();
    }


}