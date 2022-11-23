package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputExceptionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @DisplayName("예외 테스트: 입력 값이 공백일 때 예외가 발생한다.")
    @ValueSource(strings = {" ", "   "})
    void sizeTest1(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @DisplayName("예외 테스트: 입력 값이 문자일 때 예외가 발생한다.")
    @ValueSource(strings = {"문자", "English", "*&^"})
    void sizeTest2(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @DisplayName("예외 테스트: 입력 값이 2이하 일때 예외가 발생한다.")
    @ValueSource(strings = {"2", "0", "-1"})
    void sizeTest3(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @DisplayName("예외 테스트: 입력 값이 21이상 일때 예외가 발생한다.")
    @ValueSource(strings = {"21", "2222222"})
    void sizeTest4(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @DisplayName("예외 테스트: 입력 값이 U/D가 가 아닐 때 예외가 발생한다.")
    @ValueSource(strings = {"문자", "0", "A"})
    void movingTest(String input) {
        assertRandomNumberInRangeTest(() -> {
            run("3", input, "U", "Q");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 0, 0, 0);
    }

    @ParameterizedTest
    @DisplayName("예외 테스트: 입력 값이 R/Q가 아닐 때 예외가 발생한다.")
    @ValueSource(strings = {"문자", "0", "A"})
    void retryTest(String input) {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", input, "Q");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 0, 0, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
