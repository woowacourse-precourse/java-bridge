package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.TestInputView;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class UnitTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
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
        @Test
        @DisplayName("이동 도중 실패")
        void moveFailOnPath() {
            InputView inputView = new TestInputView(4, List.of("U", "D", "U"));
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker, inputView, outputView);

            assert(bridgeGame.move(List.of("U", "D", "D", "U")) == false);

            assertThat(outputStreamCaptor.toString().trim())
                    .contains(
                            "[ O |   | X ]",
                            "[   | O |   ]"
                    );
        }

        @Test
        @DisplayName("이동 마지막 실패")
        void moveFailOnEnd() {
            InputView inputView = new TestInputView(4, List.of("U", "D", "D", "D"));
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker, inputView, outputView);

            assert(bridgeGame.move(List.of("U", "D", "D", "U")) == false);

            assertThat(outputStreamCaptor.toString().trim())
                    .contains(
                            "[ O |   |   |   ]",
                            "[   | O | O | X ]"
                    );
        }

        @Test
        @DisplayName("이동 성공")
        void moveSuccess() {
            InputView inputView = new TestInputView(4, List.of("U", "D", "D", "U"));
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker, inputView, outputView);

            assert(bridgeGame.move(List.of("U", "D", "D", "U")) == true);

            assertThat(outputStreamCaptor.toString().trim())
                    .contains(
                            "[ O |   |   | O ]",
                            "[   | O | O |   ]"
                    );
        }
    }

    @Nested
    @DisplayName("재시작 테스트")
    class RetryTest {
        @Test
        @DisplayName("재시작")
        void repeatPlay() {
            InputView inputView = new TestInputView(4, List.of("R"));
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker, inputView, outputView);

            assert(bridgeGame.retry() == true);
        }

        @Test
        @DisplayName("포기")
        void quittPlay() {
            InputView inputView = new TestInputView(4, List.of("Q"));
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker, inputView, outputView);

            assert(bridgeGame.retry() == false);
        }
    }
}
