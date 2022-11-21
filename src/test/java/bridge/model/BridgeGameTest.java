package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    Bridge bridge;
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridge = Bridge.of(List.of("U", "D", "D"));
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("플레이어 이동 테스트")
    @Test
    void createMovingTest() {
        MovingResult firstResult = bridgeGame.move(Moving.UP);
        MovingResult secondResult = bridgeGame.move(Moving.UP);

        assertThat(firstResult)
                .usingRecursiveComparison()
                .isEqualTo(MovingResult.of(Moving.UP, Result.SUCCESS));

        assertThat(secondResult)
                .usingRecursiveComparison()
                .isEqualTo(MovingResult.of(Moving.UP, Result.FAIL));
    }

    @DisplayName("게임 결과 확인 테스트 - 실패")
    @Test
    void createFailTest() {
        bridgeGame.move(Moving.DOWN);
        bridgeGame.move(Moving.DOWN);

        assertThat(bridgeGame.getGameResult()).isEqualTo(Result.FAIL);
    }

    @DisplayName("게임 결과 확인 테스트 - 성공")
    @Test
    void createSuccessTest() {
        bridgeGame.move(Moving.UP);
        bridgeGame.move(Moving.DOWN);
        bridgeGame.move(Moving.DOWN);

        assertThat(bridgeGame.getGameResult()).isEqualTo(Result.SUCCESS);
    }
}