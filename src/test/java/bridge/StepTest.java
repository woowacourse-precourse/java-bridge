package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StepTest {
    @DisplayName("이동할 칸 선택시 정상적인 데이터를 넣은 경우 true를 반환하는가 체크")
    @ParameterizedTest
    @EnumSource(Step.class)
    void aaa(Step step){
        assertThat(Step.validStep(step.name())).isEqualTo(true);
    }

    @DisplayName("이동할 칸 선택시 비정상적인 데이터를 넣은 경우 false를 반환하는가 체크")
    @Test
    void aaa3(){
        assertThat(Step.validStep("Q")).isEqualTo(false);
    }

    @Test
    void bbb(){
        assertThat(Step.getStep(0)).isEqualTo(Step.D);
    }

    @Test
    void bbb1(){
        assertThat(Step.getStep(1)).isEqualTo(Step.U);
    }

    @Test
    void bbb2(){
        assertThatThrownBy(() -> Step.getStep(2))
                .isInstanceOf(NoSuchElementException.class);
    }
}