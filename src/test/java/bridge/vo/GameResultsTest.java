package bridge.vo;

import static bridge.constant.Direction.UPPER;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GameResultsTest {

    @Test
    void 마지막_시도의_성공_여부를_알_수_있다() {
        GameResults gameResult = new GameResults();

        gameResult.add(UPPER, true);
        assertThat(gameResult.wasLastSuccessful()).isTrue();
    }

    @Test
    void 게임이_끝났는지_알_수_있다() {
        GameResults gameResult = new GameResults();

        gameResult.finish();
        assertThat(gameResult.isFinished()).isTrue();
    }
}
