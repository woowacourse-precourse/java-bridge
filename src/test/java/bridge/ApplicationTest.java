package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }

    /**
     * custom test
     */

    @Nested
    @DisplayName("다리 길이 테스트")
    class BridgeSize {
        @Test
        @DisplayName("길이 5")
        void bridgeSize5() {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 0, 1));
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
            List<String> bridge = bridgeMaker.makeBridge(5);
            assertThat(bridge).containsExactly("U", "D", "D", "U", "D");
        }

        @Test
        @DisplayName("길이 2")
        void bridgeSizeShort() {
            assertSimpleTest(() -> {
                runException("2");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        @DisplayName("길이 25")
        void bridgeSizeLong() {
            assertSimpleTest(() -> {
                runException("25");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @Nested
    @DisplayName("재도전 테스트")
    class RepeatTest {
        @Test
        @DisplayName("재도전 후 다리 생성")
        void repeatMakeBridge() {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 1, 1));
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

            List<String> bridge = bridgeMaker.makeBridge(3);
            assertThat(bridge).containsExactly("U", "D", "D");

            bridge = bridgeMaker.makeBridge(3);
            assertThat(bridge).containsExactly("U", "U", "U");
        }

        @Test
        @DisplayName("재도전 후 게임 진행")
        void repeatPlay() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "U", "U", "R", "3", "D", "D", "D");
                assertThat(output()).contains(
                        "[ O | X ]",
                        "[   |   ]",
                        "[   |   |   ]",
                        "[ O | O | O ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 2"
                );

                int upSideIndex = output().indexOf("[ O | X ]");
                int downSideIndex = output().indexOf("[   |   ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);

                upSideIndex = output().indexOf("[   |   |   ]");
                downSideIndex = output().indexOf("[ O | O | O ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1, 0, 0, 0);
        }
    }

    @Nested
    @DisplayName("이동 테스트")
    class MoveTest {
        @Test
        @DisplayName("이동 실패")
        void moveFail() {
            assertRandomNumberInRangeTest(() -> {
                run("5", "D", "Q");
                assertThat(output()).contains(
                        "최종 게임 결과",
                        "[   ]",
                        "[ X ]",
                        "게임 성공 여부: 실패",
                        "총 시도한 횟수: 1"
                );

            }, 1, 1, 1, 1, 1);
        }

        @Test
        @DisplayName("이동 성공")
        void moveSuccess() {
            assertRandomNumberInRangeTest(() -> {
                run("5", "D", "D", "D", "D", "D");
                assertThat(output()).contains(
                        "최종 게임 결과",
                        "[   |   |   |   |   ]",
                        "[ O | O | O | O | O ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 1"
                );

            }, 0, 0, 0, 0, 0);
        }
    }
}
