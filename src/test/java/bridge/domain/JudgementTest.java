package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {

    /** success: 0 -> down 성공, 1 -> down 실패, 2 -> up 성공, 3 -> up 실패 **/
    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다.(down 성공)")
    @Test
    void checkResult_downSuccess() {
        List<Integer> movingSuccess = List.of(0, 0, 0);
        assertEquals(true, Judgement.checkResult(movingSuccess));
    }

    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다.(up 성공)")
    @Test
    void checkResult_upSuccess() {
        List<Integer> movingSuccess = List.of(0, 2, 2);
        assertEquals(true, Judgement.checkResult(movingSuccess));
    }

    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다.(down 실패)")
    @Test
    void checkResult_downFailure() {
        List<Integer> movingSuccess = List.of(0, 1);
        assertEquals(false, Judgement.checkResult(movingSuccess));
    }

    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다.(up 실패)")
    @Test
    void checkResult_upFailure() {
        List<Integer> movingSuccess = List.of(3);
        assertEquals(false, Judgement.checkResult(movingSuccess));
    }

    @Test
    void checkRestart() {
    }
}