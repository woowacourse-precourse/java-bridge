package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeMovingResultTest {

    @DisplayName("이동이 가능한 경우 O를 반환")
    @Test
    void MovingByPossible() {
        JudgeMovingResult judgeMovingResult = new JudgeMovingResult();

        String movingResult = judgeMovingResult.isMovingPossible("D", "D");
        String result = "O";

        Assertions.assertThat(movingResult).isEqualTo(result);
    }

    @DisplayName("이동이 불가능한 결과 X를 반환")
    @Test
    void MovingByImpossible() {
        JudgeMovingResult judgeMovingResult = new JudgeMovingResult();

        String movingResult = judgeMovingResult.isMovingPossible("D", "U");
        String result = "X";

        Assertions.assertThat(movingResult).isEqualTo(result);
    }
}