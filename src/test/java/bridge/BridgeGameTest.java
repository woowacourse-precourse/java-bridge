package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("이동 입력에 대한 예외 처리 테스트")
    @Nested
    class moveExceptionTest {
        @Test
        @DisplayName("이동할 칸은 'U' 또는 'D' 만 입력 가능합니다.")
        void checkNotMatchTest() {
            assertSimpleTest(() -> {
                runException("3", "K");
                assertThat(output()).contains(ERROR_MESSAGE, "이동할 칸은 'U' 또는 'D' 만 입력 가능합니다.");
            });
        }
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
