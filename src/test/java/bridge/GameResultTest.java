package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {

    private GameResult gameResult;

    @BeforeEach
    protected final void init() {
        gameResult = new GameResult();
    }

    @DisplayName("건너가기 성공한 지점 정상 저장")
    @Test
    void gameResultSavesSuccessTest() {
        gameResult.addResult(Step.UP, true);
        assertThat(gameResult.getSuccessSteps().get(0)).isEqualTo(Step.UP);
    }

    @DisplayName("건너가기 실패한 지점 정상 저장")
    @Test
    void gameResultSavesFailureTest() {
        gameResult.addResult(Step.UP, false);
        assertThat(gameResult.getFailStep()).isEqualTo(Step.UP);
        assertThat(gameResult.getGameStatus()).isEqualTo(GameStatus.FAIL);
    }

}
