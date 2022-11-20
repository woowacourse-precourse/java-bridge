package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExceptionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 길이 입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputStringInBridgeSize() {
        assertThatThrownBy(() -> {
            runException("HELLO");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("다리 길이 입력이 3부터 20 사이의 수가 아니면 예외가 발생한다.")
    @Test
    void inputWrongRangeNumberInBridgeSize() {
        assertThatThrownBy(() -> {
            runException("20");
            assertThat(output()).contains("[ERROR]");
        });
    }


    @Override
    protected void runMain() {

    }
}
