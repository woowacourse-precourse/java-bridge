package bridge.dto;

import static bridge.constant.Direction.UPPER;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TrialResultTest {

    @Test
    void 시도의_성공_여부를_알_수_있다() {
        TrialResult trialResult = new TrialResult(UPPER, true);

        assertThat(trialResult.wasSuccessful()).isTrue();
    }
}
