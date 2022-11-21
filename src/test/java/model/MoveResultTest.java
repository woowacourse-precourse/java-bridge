package model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.enums.MoveResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MoveResultTest {
    private static Boolean succeed = true;
    private static Boolean fail = false;

    @Nested
    @DisplayName("getMatchResult 메서드는 숫자 값을 입력받아")
    class describe_getMoving {

        @Test
        @DisplayName("알맞은 MoveResult 객체를 반환한다.")
        void returnMovingTest(){
            assertThat(MoveResult.getMatchResult(succeed)).isEqualTo(MoveResult.SUCCESS);
            assertThat(MoveResult.getMatchResult(fail)).isEqualTo(MoveResult.FAIL);
        }
    }
}
