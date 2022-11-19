package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import bridge.messages.ErrorMessage;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ValidatorTest extends NsTest {

    @DisplayName("다리 길이 숫자 범위 테스트")
    @Test
    void validateInputSizeTest() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ErrorMessage.BRIDGE_SIZE_INPUT_RANGE.getErrorMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
