package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class BridgeGameTest {

    List<String> bridge;
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridge = List.of("U", "D", "D");
        bridgeGame = new BridgeGame(bridge.size());
    }

    @DisplayName("플레이어 이동 테스트")
    @Test
    void createMovingTest() {
        MovingResult firstResult = bridgeGame.move(bridge, Moving.UP);
        MovingResult secondResult = bridgeGame.move(bridge, Moving.UP);

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
        bridgeGame.move(bridge, Moving.DOWN);

        MovingResult movingResult = bridgeGame.move(bridge, Moving.DOWN);

        assertThat(bridgeGame.getGameResult()).isEqualTo(Result.FAIL);
    }

    @DisplayName("게임 결과 확인 테스트 - 성공")
    @Test
    void createSuccessTest() {
        bridgeGame.move(bridge, Moving.UP);
        bridgeGame.move(bridge, Moving.DOWN);

        MovingResult movingResult = bridgeGame.move(bridge, Moving.DOWN);

        assertThat(bridgeGame.getGameResult()).isEqualTo(Result.SUCCESS);
    }
}