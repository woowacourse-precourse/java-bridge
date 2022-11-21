package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StepTest {

    @Test
    @DisplayName("Step의 of메소드 성공")
    void case1() {
        String safeZone = "U";
        String direction = "U";
        Step result = Step.of(safeZone, direction);
        assertThat(result).isEqualTo(Step.UP_SUCCESS);
    }

    @Test
    @DisplayName("Step의 of 메소드 실패: 유효하지 않은 파라미터")
    void case2() {
        String safeZone = "R";
        String direction = "D";
        assertThatThrownBy(() -> Step.of(safeZone, direction)).isInstanceOf(IllegalArgumentException.class);
    }

}
