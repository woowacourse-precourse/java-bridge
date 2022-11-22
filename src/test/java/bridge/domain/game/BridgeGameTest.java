package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.Square;
import bridge.domain.move.MoveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        Bridge bridge = Bridge.valueOf(List.of("U", "D"));
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("다리를 건널 수 있다면 현재 위치가 1 증가한다.")
    @Test
    void increasePosition() {
        int curPosition = bridgeGame.getPosition();
        Square square = new Square(MoveType.UP);

        bridgeGame.move(square);

        assertThat(bridgeGame.getPosition()).isEqualTo(curPosition + 1);
    }

    @DisplayName("현재 위치가 다리의 길이와 같다면 참을 반환한다.")
    @Test
    void success() {
        bridgeGame.move(new Square(MoveType.UP));
        bridgeGame.move(new Square(MoveType.DOWN));

        boolean gameSuccess = bridgeGame.isFinalSuccess();
        assertThat(gameSuccess).isTrue();
    }


    @DisplayName("재시작하는 경우 현재 위치가 0으로 초기화된다.")
    @Test
    void retryPosition() {
        Square square = new Square(MoveType.DOWN);
        bridgeGame.move(square);

        bridgeGame.retry();

        assertThat(bridgeGame.getPosition()).isEqualTo(0);
    }

    @DisplayName("재시작하는 경우 재시작 횟수가 1 증가한다.")
    @Test
    void retryCount() {
        int retryCount = bridgeGame.getRetryCount();
        Square square = new Square(MoveType.DOWN);
        bridgeGame.move(square);

        bridgeGame.retry();

        assertThat(bridgeGame.getRetryCount()).isEqualTo(retryCount + 1);
    }
}