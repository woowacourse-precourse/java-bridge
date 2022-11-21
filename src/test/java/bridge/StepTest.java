package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StepTest {
    @DisplayName("이동할 칸 선택시 정상적인 데이터를 넣은 경우")
    @ParameterizedTest
    @EnumSource(Step.class)
    void check_ValidStep_Tue(Step step){
        assertThat(Step.validStep(step.name())).isEqualTo(true);
    }

    @DisplayName("이동할 칸 선택시 비정상적인 데이터를 넣은 경우")
    @Test
    void check_ValidStep_False(){
        assertThat(Step.validStep("Q")).isEqualTo(false);
    }

    @DisplayName("다리 생성시 0으로 아래(D)를 생성하는지 체크")
    @Test
    void createBridgeByZeroToDown(){
        assertThat(Step.getStep(0)).isEqualTo(Step.D);
    }

    @DisplayName("다리 생성시 1으로 위(U)를 생성하는지 체크")
    @Test
    void createBridgeByOneToUp(){
        assertThat(Step.getStep(1)).isEqualTo(Step.U);
    }

    @DisplayName("다리에 0과 1이 아닌수가 들어가면 예외가 발생한다.")
    @Test
    void createBridgeExceptZeroAndOne(){
        assertThatThrownBy(() -> Step.getStep(2))
                .isInstanceOf(NoSuchElementException.class);
    }
}