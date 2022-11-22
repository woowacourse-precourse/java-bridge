package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

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

    @DisplayName("선택한 이동경로 D에 X저장, U에 공백 저장")
    @Test
    void recordMovingByImpossible() {
        JudgeMovingResult judgeMovingResult = new JudgeMovingResult();

        Map<String, String> movingRecord = judgeMovingResult.recordMoving("D", "X");

        Assertions.assertThat(movingRecord.get("D")).isEqualTo("X");
        Assertions.assertThat(movingRecord.get("U")).isEqualTo(" ");
    }

    @DisplayName("선택한 이동경로 U에 O저장, D에 공백 저장")
    @Test
    void recordMovingBypossible() {
        JudgeMovingResult judgeMovingResult = new JudgeMovingResult();

        Map<String, String> movingRecord = judgeMovingResult.recordMoving("U", "O");

        Assertions.assertThat(movingRecord.get("D")).isEqualTo(" ");
        Assertions.assertThat(movingRecord.get("U")).isEqualTo("O");
    }

}