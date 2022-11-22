package bridge.GameTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InputCheck;
public class BridgeSizeTest extends NsTest{

    private static final String ERROR_MESSAGE = "[ERROR]";



    @DisplayName("범위와 다른 bridgeSize 들어올 때 제대로 처리가 되는지 확인")
    @Test
    void inputBridgeSizeExceptionProcessing1() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("올바르지 않은 bridgeSize 들어올 때 제대로 처리가 되는지 확인")
    @Test
    void inputRestartExceptionProcessing2() {
        assertSimpleTest(() -> {
            runException("A");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        InputCheck.bridgeSizeValue();
    }
}
