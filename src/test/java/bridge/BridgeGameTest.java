package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    protected void init() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 1, 0));
        bridgeGame = new BridgeGame(numberGenerator, 4);
    }

    @Test
    @DisplayName(value = "생성자를 통해 잘 만들어졌는지 확인")
    void constructorTest1() {
        assertSimpleTest(() -> {
            assertThat(bridgeGame.getBridge()).containsExactly("U", "D", "U", "D");
            assertThat(bridgeGame.getBridgeCorrect()).isEmpty();
        });
    }

    @Test
    @DisplayName(value = "정상적인 move()")
    void moveTest1() {
        assertSimpleTest(() -> {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");
            bridgeGame.move("U");

            assertThat(bridgeGame.getBridgeCorrect()).containsExactly(true, true, false, false);
        });
    }

    @DisplayName(value = "move를 여러번 했을때")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 100})
    void moveTest2(int size) {
        assertSimpleTest(() -> {
            BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 1, 1, 1));
            bridgeGame = new BridgeGame(numberGenerator, 4);
            int correctTestSize = Math.min(size, 4);
            List<Boolean> bridgeCorrectTest = makeBridgeCorrectTest(true, correctTestSize);
            for (int index = 0; index < size; index++) {
                bridgeGame.move("U");
            }

            assertThat(bridgeGame.getBridgeCorrect()).containsExactlyElementsOf(bridgeCorrectTest);
        });
    }

    @Test
    @DisplayName(value = "정상적인 retry()")
    void retryTest1() {
        assertSimpleTest(() -> {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.retry();

            assertThat(bridgeGame.getBridgeCorrect()).containsExactly(true);
        });
    }

    private List<Boolean> makeBridgeCorrectTest(boolean correct, int size) {
        List<Boolean> bridgeCorrectTest = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            bridgeCorrectTest.add(correct);
        }
        return bridgeCorrectTest;
    }
}