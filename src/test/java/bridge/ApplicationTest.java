package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @DisplayName("기능 테스트")
    @Nested
    class FeatureTest {
        @Test
        void 기능_테스트_1() {
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
        void 기능_테스트_2_재시도해서_성공() {
            assertRandomNumberInRangeTest(() -> {
                run("5", "U", "D", "U", "U", "R", "U", "D", "U", "D", "U");
                assertThat(output()).contains(
                        "[ O |   | O | X ]",
                        "[   | O |   |   ]",
                        "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                        "최종 게임 결과",
                        "[ O |   | O |   | O ]",
                        "[   | O |   | O |   ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 2"
                );

                int upSideIndex = output().indexOf("[ O |   | O |   | O ]");
                int downSideIndex = output().indexOf("[   | O |   | O |   ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1, 0, 1);
        }

        @Test
        void 기능_테스트_3_죽고나서_빡쳐서_그만둠() {
            assertRandomNumberInRangeTest(() -> {
                run("5", "U", "D", "U", "U", "Q");
                assertThat(output()).contains(
                        "[ O |   | O | X ]",
                        "[   | O |   |   ]",
                        "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                        "최종 게임 결과",
                        "[ O |   | O | X ]",
                        "[   | O |   |   ]",
                        "게임 성공 여부: 실패",
                        "총 시도한 횟수: 1"
                );

                int upSideIndex = output().indexOf("[ O |   | O | X ]");
                int downSideIndex = output().indexOf("[   | O |   |   ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1, 0, 1);
        }

        @Test
        void 기능_테스트_4_20개의_다리를_극적인_확률로_통과() {
            assertRandomNumberInRangeTest(() -> {
                run("20", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D",
                        "U", "D", "U", "D", "U", "D", "U", "D", "U", "D");
                assertThat(output()).contains(
                        "최종 게임 결과",
                        "[ O |   | O |   | O |   | O |   | O |   | O |   | O |   | O |   | O |   | O |   ]",
                        "[   | O |   | O |   | O |   | O |   | O |   | O |   | O |   | O |   | O |   | O ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 1"
                );

                int upSideIndex = output().indexOf(
                        "[ O |   | O |   | O |   | O |   | O |   | O |   | O |   | O |   | O |   | O |   ]");
                int downSideIndex = output().indexOf(
                        "[   | O |   | O |   | O |   | O |   | O |   | O |   | O |   | O |   | O |   | O ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0);
        }
    }

    @DisplayName("예외 테스트")
    @Nested
    class ExceptionTest {
        @Test
        void 예외_테스트_1_다리_사이즈로_문자_입력() {
            assertSimpleTest(() -> {
                runException("a");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_2_다리_사이즈로_실수_입력() {
            assertSimpleTest(() -> {
                runException("3.5");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_3_다리_사이즈로_큰_수_입력() {
            assertSimpleTest(() -> {
                runException("21");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_4_다리_사이즈로_음수_입력() {
            assertSimpleTest(() -> {
                runException("-1");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_5_다리_사이즈로_공백_입력() {
            assertSimpleTest(() -> {
                runException(" ");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_6_이동할_칸으로_다른거_입력() {
            assertSimpleTest(() -> {
                runException("3", "X");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_7_이동할_칸으로_공백_입력() {
            assertSimpleTest(() -> {
                runException("3", " ");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_8_게임커맨드로_다른거_입력() {
            assertRandomNumberInRangeTest(
                    () -> {
                        runException("5", "U", "U", "X");
                        assertThat(output()).contains(ERROR_MESSAGE);
                    },
                    1, 0, 1, 1, 1
            );
        }

        @Test
        void 예외_테스트_9_게임커맨드로_공백_입력() {
            assertRandomNumberInRangeTest(
                    () -> {
                        runException("5", "U", "U", " ");
                        assertThat(output()).contains(ERROR_MESSAGE);
                    },
                    1, 0, 1, 1, 1
            );
        }
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
}
