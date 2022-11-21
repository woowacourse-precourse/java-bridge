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
    @DisplayName(value = "모두 맞췄을때 멈출수 있는가 확인")
    void checkMatchBridgeTest1() {
        assertSimpleTest(() -> {
            bridgeGame.addBridgeCorrect("U");
            bridgeGame.addBridgeCorrect("D");
            bridgeGame.addBridgeCorrect("U");
            bridgeGame.addBridgeCorrect("D");

            assertThat( bridgeGame.keepMove()).isEqualTo(false);
        });
    }

    @Test
    @DisplayName(value = "최근에 틀렸을때 멈출수 있는가 확인")
    void checkMatchBridgeTest2() {
        assertSimpleTest(() -> {
            bridgeGame.addBridgeCorrect("U");
            bridgeGame.addBridgeCorrect("U");

            assertThat( bridgeGame.keepMove()).isEqualTo(false);
        });
    }

    @Test
    @DisplayName(value = "중간까지 맞았을때 지속할수 있는가 확인")
    void checkMatchBridgeTest3() {
        assertSimpleTest(() -> {
            bridgeGame.addBridgeCorrect("U");
            bridgeGame.addBridgeCorrect("D");

            assertThat( bridgeGame.keepMove()).isEqualTo(true);
        });
    }

    @Test
    @DisplayName(value = "모두 맞았을때 출력이 잘 나오는가 확인")
    void printMapTest1(){
        assertSimpleTest(() -> {
            bridgeGame.addBridgeCorrect("U");
            bridgeGame.addBridgeCorrect("D");
            bridgeGame.addBridgeCorrect("U");
            bridgeGame.addBridgeCorrect("D");

            assertThat(bridgeGame.getMapLines())
                    .containsExactly("[ O |   | O |   ]"
                            , "[   | O |   | O ]");
        });
    }

    @Test
    @DisplayName(value = "정상적인 doRetry()")
    void retryTest1() {
        assertSimpleTest(() -> {
            bridgeGame.addBridgeCorrect("U");
            bridgeGame.addBridgeCorrect("D");
            bridgeGame.addBridgeCorrect("D");
            bridgeGame.doRetry();

            assertThat(bridgeGame.keepMove()).isEqualTo(true);
        });
    }

    @Test
    @DisplayName(value = "비정상적인 doRetry()")
    void retryTest2() {
        assertSimpleTest(() -> {
            bridgeGame.doRetry();

            assertThat(bridgeGame.keepMove()).isEqualTo(true);
        });
    }

    @Test
    @DisplayName(value = "비정상적인 doRetry()")
    void retryTest3() {
        assertSimpleTest(() -> {
            bridgeGame.addBridgeCorrect("U");
            bridgeGame.doRetry();
            assertThat(bridgeGame.keepMove()).isEqualTo(true);
        });
    }

}