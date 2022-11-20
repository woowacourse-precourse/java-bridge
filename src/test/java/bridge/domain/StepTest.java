package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepTest {

    @DisplayName("위/아래 나타내는 String 검증")
    @Test
    void findByUserInputDirection() {
        assertThat(Step.findByUserInputDirection("U")).isEqualTo(Step.UP);
    }

    @DisplayName("위/아래 나타내는 Integer 검증")
    @Test
    void findByGeneratedDirection() {
        assertThat(Step.findBySystemInputDirection(1)).isEqualTo(Step.UP);
    }
}
