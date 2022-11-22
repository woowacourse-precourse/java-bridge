package bridge;

import bridge.constants.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MoveTest extends NsTest {
    @DisplayName("move 옵션을 포함한 String 입력 예외처리")
    @Test
    void exception_move_contains_option() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "US");
            assertThat(output()).contains(ErrorMessage.ERROR_NOT_VALID_MOVE.getDescription());
        }, 0, 1, 0);
    }
    @DisplayName("move에 Integer 입력 예외처리")
    @Test
    void exception_move_Integer() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "US");
            assertThat(output()).contains(ErrorMessage.ERROR_NOT_VALID_MOVE.getDescription());
        }, 0, 1, 0);
    }
    protected void runMain() {
        Application.main(new String[]{});
    }

}
