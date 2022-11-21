package bridge;

import bridge.domain.bridgeGame.gameStatics.GameStatics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameStaticsTest {
    GameStatics gameStatics;
    @BeforeEach
    void setUp() {
        gameStatics = GameStatics.initStatics();
    }

    @DisplayName("시도 횟수, 게임 실행 결과 업데이트")
    @Test
    void updateGameStatics() {
        gameStatics.increaseAttemptCount();
        gameStatics.updateCrossResult(false);

        Queue<String> result = gameStatics.getStaticsString();

        assertThat(result.poll()).isEqualTo("실패");
        assertThat(result.poll()).isEqualTo("2");
    }
}
