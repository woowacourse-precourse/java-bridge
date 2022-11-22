package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.TestInputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class UnitTest {
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
    @DisplayName("다리 길이 테스트")
    class BridgeSize {
        private BridgeNumberGenerator numberGenerator;
        private BridgeMaker bridgeMaker;

        @Test
        @DisplayName("길이 5")
        void bridgeSize5() {
            numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 1, 0, 1));
            bridgeMaker = new BridgeMaker(numberGenerator);
            List<String> bridge = bridgeMaker.makeBridge(5);
            assertThat(bridge).containsExactly("U", "D", "D", "U", "D");
        }

        @Test
        @DisplayName("길이 10")
        void bridgeSize10() {
            numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 0, 1, 1, 0, 0, 1, 1, 0, 0));
            bridgeMaker = new BridgeMaker(numberGenerator);
            List<String> bridge = bridgeMaker.makeBridge(10);
            assertThat(bridge).containsExactly("D", "D", "U", "U", "D", "D", "U", "U", "D", "D");
        }

        @Test
        @DisplayName("길이 20")
        void bridgeSize20() {
            numberGenerator = new ApplicationTest.TestNumberGenerator(
                    newArrayList(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1)
            );
            bridgeMaker = new BridgeMaker(numberGenerator);
            List<String> bridge = bridgeMaker.makeBridge(20);
            assertThat(bridge).containsExactly(
                    "D", "D", "D", "D", "D",
                    "U", "U", "U", "U", "U",
                    "D", "D", "D", "D", "D",
                    "U", "U", "U", "U", "U");
        }
    }

    @Nested
    @DisplayName("다리 출력 테스트")
    class PrintMapTest{
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        private final PrintStream standardOut = System.out;
        private final OutputView outputView = new OutputView();

        @BeforeEach
        void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @AfterEach
        void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        @DisplayName("다리 중간 출력")
        void printBridgeInMiddle() {
            List<String> bridge = List.of("U", "U", "U", "D");

            outputView.printMap(bridge, 1, false);

            assertThat(outputStreamCaptor.toString().trim())
                    .contains("[ O |   ]",
                            "[   | X ]");
        }

        @Test
        @DisplayName("다리 오류")
        void printBridgeWrong() {
            List<String> bridge = List.of("U", "U", "U", "D");

            outputView.printMap(bridge, 3, false);

            assertThat(outputStreamCaptor.toString().trim())
                    .contains("[ O | O | O | X ]",
                            "[   |   |   |   ]");
        }

        @Test
        @DisplayName("다리 정답")
        void printBridgeCorrect() {
            List<String> bridge = List.of("U", "U", "U", "D");

            outputView.printMap(bridge, 3, true);

            assertThat(outputStreamCaptor.toString().trim())
                    .contains("[ O | O | O |   ]",
                            "[   |   |   | O ]");
        }
    }

    @Nested
    @DisplayName("이동 테스트")
    class MoveTest {
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        private final PrintStream standardOut = System.out;
        private final OutputView outputView = new OutputView();

        @BeforeEach
        void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @AfterEach
        void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        @DisplayName("이동 실패")
        void moveFail() {
            InputView inputView = new TestInputView(4, List.of("U", "D", "U"));

            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker, inputView, outputView);

            bridgeGame.move(List.of("U", "D", "D", "U"));

            assertThat(outputStreamCaptor.toString().trim())
                    .contains(
                            "[ O |   | X ]",
                            "[   | O |   ]"
                    );
        }

        /*@Test
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
        }*/
    }

}
