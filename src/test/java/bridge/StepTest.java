package bridge;

import bridge.domain.game.SuccessStep;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StepTest {
    @Test
    void 성공_실패_테스트() {
        assertThat(SuccessStep.compareStep("U", "D")).isEqualTo(SuccessStep.FAIL);
        assertThat(SuccessStep.compareStep("D", "D")).isEqualTo(SuccessStep.SUCCESS);
    }

    @Test
    void 논리값_성공여부_테스트() {
        assertThat(SuccessStep.getResultbyStatus(false)).isEqualTo("실패");
        assertThat(SuccessStep.getResultbyStatus(true)).isEqualTo("성공");
    }


}
