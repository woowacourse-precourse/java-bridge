package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

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


    @Nested
    class 다리_생성_테스트 {

        @Test
        void 다리_생성_테스트_길이_3() {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
            List<String> bridge = bridgeMaker.makeBridge(3);
            assertThat(bridge).containsExactly("U", "D", "D");
        }

        @Test
        void 다리_생성_테스트_길이_10() {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 1, 0, 1, 0, 1, 0, 1, 0));
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
            List<String> bridge = bridgeMaker.makeBridge(10);
            assertThat(bridge).containsExactly("U", "D", "U", "D", "U", "D", "U", "D", "U", "D");
        }

    }


    @Nested
    class 기능_테스트 {

        private String expectUpSide, expectDownSide;

        void validateSequence(String expectUpSide, String expectDownSide) {
            int upSideIndex = output().indexOf(expectUpSide);
            int downSideIndex = output().indexOf(expectDownSide);
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }

        void validateMomentUserPath(String expectUpSide, String expectDownSide) {
            assertThat(output()).contains(
                    expectUpSide,
                    expectDownSide
            );
            validateSequence(expectUpSide, expectDownSide);
        }

        void validateGameResult(String expectUpSide, String expectDownSide, String resultOfGame, int tryCnt) {
            assertThat(output()).contains(
                    "최종 게임 결과",
                    expectUpSide,
                    expectDownSide,
                    "게임 성공 여부: " + resultOfGame,
                    "총 시도한 횟수: " + tryCnt
            );
            validateSequence(expectUpSide, expectDownSide);
        }

        @Test
        void 기능_테스트_결과_성공_시도한_횟수_1() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "U", "D", "U");

                validateGameResult(
                        "[ O |   | O ]",
                        "[   | O |   ]",
                        "성공",
                        1
                );
            }, 1, 0, 1);
        }

        @Test
        void 기능_테스트_결과_성공_시도한_횟수_3() {
            assertRandomNumberInRangeTest(() -> {
                run("5", "U", "R", "D", "D", "D", "D", "R", "U", "U");

                validateMomentUserPath(
                        "[ X ]",
                        "[   ]"
                );

                validateMomentUserPath(
                        "[   |   |   |   ]",
                        "[ O | O | O | X ]"
                );

                validateGameResult(
                        "[   |   |   | O | O ]",
                        "[ O | O | O |   |   ]",
                        "성공",
                        3
                );
            }, 0, 0, 0, 1, 1);
        }

        @Test
        void 기능_테스트_결과_실패_시도한_횟수_1() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "D", "Q");

                validateSequence(
                        "[   ]",
                        "[ X ]"
                );

                assertThat(output()).contains("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

                validateGameResult(
                        "[   ]",
                        "[ X ]",
                        "실패",
                        1
                );
            }, 1, 0, 0);
        }

        @Test
        void 기능_테스트_결과_실패_시도한_횟수_2() {
            assertRandomNumberInRangeTest(() -> {
                run("8", "U", "R", "D", "D", "D", "D", "R", "U", "U", "D", "D", "Q");

                assertThat(output()).contains("[ERROR] U 또는 D를 입력해주세요. ");

                validateSequence(
                        "[ O |   |   |   ]",
                        "[   | O | O | X ]"
                );

                assertThat(output()).contains("[ERROR] R 또는 Q를 입력해주세요. ");

                validateSequence(
                        "[ O |   |   | O | O |   |   ]",
                        "[   | O | O |   |   | O | X ]"
                );

                validateGameResult(
                        "[ O |   |   | O | O |   |   ]",
                        "[   | O | O |   |   | O | X ]",
                        "실패",
                        2
                );
            }, 1, 0, 0, 1, 1, 0, 1, 0);
        }
    }


    @Nested
    class 예외_테스트 {
        @Test
        void 예외_테스트() {
            assertSimpleTest(() -> {
                runException("a");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_잘못된_길이를_입력한_경우() {
            assertSimpleTest(() -> {
                runException("-1.213");
                assertThat(output()).contains("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다. ");
            });
        }

        @Test
        void 예외_테스트_잘못된_잘못된_방향을_입력한_경우() {
            assertSimpleTest(() -> {
                runException("5", "R");
                assertThat(output()).contains("[ERROR] U 또는 D를 입력해주세요. ");
            });
        }
    }
}
