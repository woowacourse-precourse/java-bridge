package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RetryTest extends NsTest {
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void Retry_Input_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "RR");
            assertThat(output()).contains("ERROR");

        }, 1, 0, 1);
    }
    @Test
    void Retry_테스트_성공() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R","U","D","U");
            assertThat(output()).contains("성공");

        }, 1, 0, 1);
    }
    @Test
    void Retry_테스트_실패() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            assertThat(output()).contains("실패");

        }, 1, 0, 1);
    }
}
