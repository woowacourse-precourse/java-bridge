package bridge;

import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;

public class BridgeGeneratorTest extends NsTest{
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
    @Test
    void 다리길이_테스트_Upper() {
        assertRandomNumberInRangeTest(() -> {
            run("21", "U", "D", "U");
            assertThat(output()).contains("ERROR");

        }, 1, 0, 1);
    }
    @Test
    void 다리길이_테스트_Lower() {
        assertRandomNumberInRangeTest(() -> {
            run("1", "U", "D", "U");
            assertThat(output()).contains("ERROR");

        }, 1, 0, 1);
    }
    @Test
    void 다리길이_테스트_Not_Integer() {
        assertRandomNumberInRangeTest(() -> {
            run("s", "U", "D", "U");
            assertThat(output()).contains("ERROR");

        }, 1, 0, 1);
    }

}
