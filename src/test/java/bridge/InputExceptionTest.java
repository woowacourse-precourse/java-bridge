package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputExceptionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("예외 테스트: 입력 값이 공백일 때 예외가 발생한다.")
    void sizeTest1() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트: 입력 값이 문자일 때 예외가 발생한다.")
    void sizeTest2() {
        assertSimpleTest(() -> {
            runException("문자");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트: 입력 값이 2이하 일때 예외가 발생한다.")
    void sizeTest3() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트: 입력 값이 21이상 일때 예외가 발생한다.")
    void sizeTest4() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트: 입력 값이 U/D가 가 아닐 때 예외가 발생한다.")
    void movingTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "A", "U", "Q");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 0, 0, 0);
    }

    @Test
    @DisplayName("예외 테스트: 입력 값이 R/Q가 아닐 때 예외가 발생한다.")
    void retryTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "A", "Q");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 0, 0, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
