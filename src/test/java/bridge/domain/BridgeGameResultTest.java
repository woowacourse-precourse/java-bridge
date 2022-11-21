package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameResultTest extends NsTest {

    @DisplayName("모두 일치하는 커멘드를 입력한 경우 제대로 작동하는지 확인한다.")
    @Test
    void create_UDU_Bridge_print_O() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                "[ O |   | O ]",
                "[   | O |   ]"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @DisplayName("모두 불일치하는 커멘드를 입력한 경우 제대로 작동하는지 확인한다.")
    @Test
    void create_UDU_Bridge_print_X() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "D");
            assertThat(output()).contains(
                "[   | X |   ]",
                "[ X |   | X ]"
            );

            int upSideIndex = output().indexOf("[   | X |   ]");
            int downSideIndex = output().indexOf("[ X |   | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }


    @DisplayName("상황에 맞는 커멘드를 입력한 경우 제대로 작동하는지 확인한다.")
    @Test
    void create_UDU_Bridge_print_O_X() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D");
            assertThat(output()).contains(
                "[ O |   |   ]",
                "[   | O | X ]"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}