package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionInputTest extends NsTest {
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 다리이동_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "SS", "D", "U");
            assertThat(output()).contains("ERROR");

        }, 1, 0, 1);
    }
}
