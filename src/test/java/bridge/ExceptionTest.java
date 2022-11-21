package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest extends NsTest {

    private final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("bridge 길이 입력에 대한 예외처리 테스트")
    @ValueSource(strings = {"a", "-1", "2", "21"})
    @ParameterizedTest
    void enterInvalidBridgeLengthTest(String input) {

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("이동 관련 입력에 대한 예외처리 테스트")
    @ValueSource(strings = {"a", "0", "u", "d"})
    @ParameterizedTest
    void enterInvalidMovingBlockTest(String input) {
        assertSimpleTest(() -> {
            runException("3", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("재시작 관련 입력에 대한 예외처리 테스트")
    @ValueSource(strings = {"a", "0", "r", "q"})
    @ParameterizedTest
    void enterInvalidGameCommandTest(String input) {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 0, 0, 1);
    }

    @Override
    protected void runMain() {

        Application.main(new String[]{});
    }
}
