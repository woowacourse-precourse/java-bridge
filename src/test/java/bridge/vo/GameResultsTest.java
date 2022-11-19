package bridge.vo;

import static bridge.constant.Direction.UPPER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import bridge.dto.TrialResult;

public class GameResultsTest {

    @Test
    void 마지막_시도의_성공_여부를_알_수_있다() {
        List<TrialResult> trialResults = List.of(new TrialResult(UPPER, true));
        GameResults gameResult = new GameResults(trialResults, true);

        assertThat(gameResult.wasLastSuccessful()).isTrue();
    }

    @Test
    void 게임이_끝났는지_알_수_있다() {
        List<TrialResult> trialResults = List.of(new TrialResult(UPPER, true));
        GameResults gameResult = new GameResults(trialResults, true);

        assertThat(gameResult.isFinished()).isTrue();
    }
}
