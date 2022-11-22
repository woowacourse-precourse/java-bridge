package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ValidatorTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 길이입력오류확인() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[] {});
    }
}
