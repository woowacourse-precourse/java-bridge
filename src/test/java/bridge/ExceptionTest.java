package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 길이 입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputStringInBridgeSize() {
        assertSimpleTest(() -> {
            runException("HELLO");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 길이 입력이 3부터 20 사이의 수가 아니면 예외가 발생한다.")
    @Test
    void inputWrongRangeNumberInBridgeSize() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
