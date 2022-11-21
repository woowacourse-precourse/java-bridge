package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StepTest {
    @DisplayName("이동할 칸 선택시 정상적인 데이터를 넣은 경우")
    @ParameterizedTest
    @EnumSource(Step.class)
    void aaa(Step step){
        assertThat(Step.validStep(step.name())).isEqualTo(true);
    }

    @DisplayName("이동할 칸 선택시 비정상적인 데이터를 넣은 경우")
    @Test
    void aaa3(){
        assertThat(Step.validStep("Q")).isEqualTo(false);
    }
}