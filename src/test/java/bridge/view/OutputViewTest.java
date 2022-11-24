package bridge.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.GameResult;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OutputViewTest {
    OutputView outputView;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
    }

    @Nested
    class PrintMapTest extends NsTest {
        String inputMap;

        @Test
        public void printMap() {
            inputMap = "[ O | O |   | X ]\n[   |   | O |   ]";
            assertSimpleTest(() -> {
                        run();
                        assertThat(output()).contains(
                                "[ O | O |   | X ]",
                                "[   |   | O |   ]"
                        );
                    }
            );
        }

        @Override
        protected void runMain() {
            outputView.printMap(inputMap);
        }
    }

    @Nested
    @DisplayName("printResult() 테스트")
    class PrintResultTest extends NsTest {
        OutputView outputView;
        GameResult gameResult;

        @BeforeEach
        public void setUp() {
            outputView = new OutputView();
        }

        @Test
        @DisplayName("지도와 일치한다.")
        public void printResult() {
            String map = "[   | O |   | O |   ]\n[ O |   | O |   | X ]";
            gameResult = new GameResult(map, false, 1);

            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "최종 게임 결과",
                        "[   | O |   | O |   ]",
                        "[ O |   | O |   | X ]"
                );
            });
        }

        @ParameterizedTest
        @ValueSource(booleans = {true, false})
        @DisplayName("성공여부가 일치한다.")
        public void printExactSuccess(boolean success) {
            prepareGameResultFor(success);

            Map<Boolean, String> successToString = Map.of(
                    true, "성공",
                    false, "실패"
            );

            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "게임 성공 여부: " + successToString.get(success)
                );
            });
        }

        private void prepareGameResultFor(boolean success) {
            Map<Boolean, String> lastStep = Map.of(
                    true, "O",
                    false, "X"
            );
            String map = "[   | O |   | O |   ]\n[ O |   | O |   | " + lastStep.get(success) + " ]";

            gameResult = new GameResult(map, success, 1);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5})
        @DisplayName("시도횟수가 일치한다.")
        public void printExactAttempts(int attempt) {
            prepareGameResultFor(attempt);
            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "총 시도한 횟수: " + attempt
                );
            });
        }

        private void prepareGameResultFor(int attempts) {
            Map<Boolean, String> lastStep = Map.of(
                    true, "O",
                    false, "X"
            );
            String map = "[   | O |   | O |   ]\n[ O |   | O |   | X ]";
            gameResult = new GameResult(map, true, attempts);
        }

        @Override
        protected void runMain() {
            outputView.printResult(gameResult);
        }
    }
}
