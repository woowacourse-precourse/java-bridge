package bridge.domain;

import static bridge.domain.Judgement.checkRestart;
import static bridge.domain.Judgement.checkResult;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {

    /** success: 0 -> down 성공, 1 -> down 실패, 2 -> up 성공, 3 -> up 실패 **/
    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다.(down 성공)")
    @Test
    void checkResultTest_downSuccess() {
        List<Integer> movingSuccess = List.of(0, 0, 0);
        assertTrue(checkResult(movingSuccess));
    }

    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다.(up 성공)")
    @Test
    void checkResultTest_upSuccess() {
        List<Integer> movingSuccess = List.of(0, 2, 2);
        assertTrue(checkResult(movingSuccess));
    }

    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다.(down 실패)")
    @Test
    void checkResultTest_downFailure() {
        List<Integer> movingSuccess = List.of(0, 1);
        assertFalse(checkResult(movingSuccess));
    }

    @DisplayName("이동한 칸을 건널 수 있는지 없는지 확인한다.(up 실패)")
    @Test
    void checkResultTest_upFailure() {
        List<Integer> movingSuccess = List.of(3);
        assertFalse(checkResult(movingSuccess));
    }

    @DisplayName("입력된 값에 따라 재시작할 지, 종료할 지를 결정한다.")
    @Test
    void checkRestartTest() {
        List<String> gameCommands = List.of("R", "Q");
        List<Boolean> results = List.of(true, false);
        for (int i = 0; i < gameCommands.size(); i++) {
            assertEquals(results.get(i), checkRestart(gameCommands.get(i)));
        }
    }
}