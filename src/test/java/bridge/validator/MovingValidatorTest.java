package bridge.validator;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static bridge.utils.ErrorMessages.ERROR_INVALID_MOVING;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MovingValidatorTest extends NsTest {
    @DisplayName("이동할 칸 입력값이 U 또는 D가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"3,a", "3,Q", "20,R", "20,12"})
    void moveBridgeByInValidMoving(String size, String moving) {
        assertSimpleTest(() -> {
            runException(size, moving);
            assertThat(output()).contains(ERROR_INVALID_MOVING);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
