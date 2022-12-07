package bridge.validator;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static bridge.utils.ErrorMessages.ERROR_INVALID_GAME_COMMAND;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameCommandValidatorTest extends NsTest {
    @DisplayName("재시도 여부 입력값이 R 또는 Q가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"3,U,D,D", "3,Q", "20,R", "20,12"})
    void moveBridgeByInValidMoving(String size, String moving) {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D");
            assertThat(output()).contains(ERROR_INVALID_GAME_COMMAND);
        }, 1, 1, 1, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
