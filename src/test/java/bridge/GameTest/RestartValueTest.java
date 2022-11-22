package bridge.GameTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InputCheck;

public class RestartValueTest extends NsTest{

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("재시작 관련 값(R)이 들어올 때 제대로 처리가 되는지 확인")
    @Test
    void inputRestartRValueProcessing() {
        boolean result = game.BridgeGame.retry("R");
        assertThat(result).isTrue();
    }

    @DisplayName("재시작 관련 값(Q)이 들어올 때 제대로 처리가 되는지 확인")
    @Test
    void inputRestartQValueProcessing() {
        boolean result = game.BridgeGame.retry("Q");
        assertThat(result).isFalse();
    }

    @DisplayName("재시작 관련 값에 이상한 값이 들어올 때 제대로 처리가 되는지 확인")
    @Test
    void inputRestartExceptionProcessing() {
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
