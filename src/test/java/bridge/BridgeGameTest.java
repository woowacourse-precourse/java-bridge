package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
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

    @DisplayName("이동 입력 후, 맵 출력에 대한 테스트")
    @Nested
    class moveAndPrintMapTest {
        @Test
        void moveUpSuccessTest() {
            assertRandomNumberInRangeTest(() -> {
                runException("3", "U");
                assertThat(output()).contains(
                        "[ O ]",
                        "[   ]"
                );

                int upSideIndex = output().indexOf("[ O ]");
                int downSideIndex = output().indexOf("[   ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 1, 1);
        }
        @Test
        void moveUpFailTest() {
            assertRandomNumberInRangeTest(() -> {
                runException("3", "U");
                assertThat(output()).contains(
                        "[ X ]",
                        "[   ]"
                );

                int upSideIndex = output().indexOf("[ X ]");
                int downSideIndex = output().indexOf("[   ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 0, 0, 0);
        }
        @Test
        void moveDownSuccessTest() {
            assertRandomNumberInRangeTest(() -> {
                runException("3", "D");
                assertThat(output()).contains(
                        "[   ]",
                        "[ O ]"
                );

                int upSideIndex = output().indexOf("[   ]");
                int downSideIndex = output().indexOf("[ O ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 0, 0, 0);
        }
        @Test
        void moveDownFailTest() {
            assertRandomNumberInRangeTest(() -> {
                runException("3", "D");
                assertThat(output()).contains(
                        "[   ]",
                        "[ X ]"
                );

                int upSideIndex = output().indexOf("[   ]");
                int downSideIndex = output().indexOf("[ X ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 1, 1);
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
