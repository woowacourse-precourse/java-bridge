package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(3);
    }

    @DisplayName("이동할 수 있을 경우에 이동 가능 판별 테스트")
    @Test
    void move() {
        int index = 0;
        String movePosition = bridgeGame.getBridges().get(index);
        boolean isPassable = bridgeGame.move(movePosition, index);
        Assertions.assertThat(isPassable).isTrue();
    }

    @DisplayName("재시도, 종료 여부 판별 중 재시도 테스트")
    @Test
    void retry() {
        String inputCommand = "R";
        boolean isRetry = bridgeGame.retry(inputCommand);
        Assertions.assertThat(isRetry).isTrue();
    }
}