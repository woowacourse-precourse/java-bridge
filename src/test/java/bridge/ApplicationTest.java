package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Nested
    class PlayerTest {

        Player player = new Player();

        @AfterEach
        @DisplayName("초기화")
        void initialize() {
            player.initialize();
        }

        @Test
        @DisplayName("초기화 테스트")
        void initializeTest() {
            player.saveLastChoice("U", false);
            player.getGameHistory();
            player.initialize();

            assertThat(player.getGameHistory()).isEqualTo(new ArrayList<>());
            assertThat(player.getPosition()).isEqualTo(-1);
        }

        @ParameterizedTest
        @DisplayName("위치 이동, 반환")
        @CsvSource({"3", "5", "9"})
        void moveTest(int steps) {
            for (int step = 0; step < steps; step++) {
                player.move();
            }

            assertThat(player.getPosition()).isEqualTo(steps - 1 );
        }

        @ParameterizedTest
        @DisplayName("저장 기능")
        @CsvSource({"U, D, U, true, true, false", "U, U, D, false, false, true"})
        void saveTest(String one, String two, String three, boolean first, boolean second, boolean third) {
            String[] choices = {one, two, three};
            boolean[] results = {first, second, third};

            for (int step = 0; step < 3; step++) {
                player.saveLastChoice(choices[step], results[step]);
                player.saveHistory();
            }

            assertThat(player.getResult()).isEqualTo(third);
            assertThat(player.getLastChoice()).isEqualTo(three);
            assertThat(player.getGameHistory()).isEqualTo(new ArrayList<>(Arrays.asList(choices)));

        }
    }

    @Nested
    class BridgeGameTest {

        Player player = new Player();

        @AfterEach
        @DisplayName("초기화")
        void initializeTest() {
            player.initialize();
        }

        @ParameterizedTest
        @DisplayName("게임 진행 완료")
        @CsvSource({"3", "9", "15"})
        void checkGameCompletionTest(int bridgeLength) {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker, bridgeLength);
            for (int step = 0; step < bridgeLength; step++) {
                bridgeGame.move("U", player);
            }

            assertThat(bridgeGame.checkGameCompletion(player)).isTrue();
        }

        @ParameterizedTest
        @DisplayName("이동 테스트")
        @CsvSource({"1, 1, 0, 1, U, U, D, U", "0, 0, 1, 0, D, D, U, D"})
        void moveTest(int zero, int one, int two, int three, String first, String second, String third, String fourth) {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(zero, one, two, three));
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 4);

            String[] inputs = {first, second, third, fourth};
            int[] generatedNumbers = {zero, one, two, three};
            String[] converter = {"D", "U"};

            for (int step = 0; step < 4; step ++) {
                boolean nextStep = bridgeGame.move(inputs[step], player);
                String expected = converter[generatedNumbers[step]];
                assertThat(nextStep).isEqualTo(expected.equals(inputs[step]));
            }
        }
    }

    @Nested
    class ControllerTest {
        @Test
        void failTest() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "U", "D", "U", "Q");
                assertThat(output()).contains(
                        "[ O |   | X ]",
                        "[   | O |   ]",
                        "최종 게임 결과",
                        "[ O |   | X ]",
                        "[   | O |   ]",
                        "게임 성공 여부: 실패",
                        "총 시도한 횟수: 1"
                );

                int upSideIndex = output().indexOf("[ O |   | X ]");
                int downSideIndex = output().indexOf("[   | O |   ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 0);
        }
    }
}
