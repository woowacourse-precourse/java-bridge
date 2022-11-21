package bridge.enums;

import bridge.enums.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StepTest {

    @Test
    void 움직일_수_있는_칸의_번호를_받아서_움직일_수_있는_칸_이니셜_반환() {
        int downStepNumber = 0;
        int upStepNumber = 1;
        String downStepInitial = Step.getMovableStepInitial(downStepNumber);
        String upStepInitial = Step.getMovableStepInitial(upStepNumber);

        assertThat(downStepInitial).isEqualTo("D");
        assertThat(upStepInitial).isEqualTo("U");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 20, 200, 2000, 20000})
    void 움직일_수_있는_칸의_번호가_0_또는_1이_아니면_예외_발생(int movableStepNumber) {
        assertThatThrownBy(() -> Step.getMovableStepInitial(movableStepNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}