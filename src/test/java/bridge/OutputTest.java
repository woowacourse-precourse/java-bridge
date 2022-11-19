package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest extends NsTest {

    @DisplayName("현재까지 이동한 칸 출력")
    @Test
    void 다리상태_DDU() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "D", "U");
            assertThat(output()).contains(
                    "[   |   | O ]",
                    "[ O | O |   ]"
            );

            int upSideIndex = output().indexOf("[   |   | O ]");
            int downSideIndex = output().indexOf("[ O | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
