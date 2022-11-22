package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest extends FunctionNsTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    protected void initBridge() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 1, 0));
        bridgeGame = new BridgeGame(numberGenerator, 4);
    }

    @Test
    @DisplayName(value = "정답할때 move가 잘 동작하는지")
    public void moveTest1() {
        assertSimpleTest(() -> {
            command("U", "D", "U", "D");
            bridgeGame.move();
            assertThat(output())
                    .contains("[ O |   | O |   ]" + System.lineSeparator() + "[   | O |   | O ]");
        });
    }

    @Test
    @DisplayName(value = "실패시 move가 잘 동작하는지")
    public void moveTest2() {
        assertSimpleTest(() -> {
            command("U", "U");

            bridgeGame.move();
            assertThat(output())
                    .contains("[ O | X ]" + System.lineSeparator() + "[   |   ]");
        });
    }

    @Test
    @DisplayName(value = "잘못된 입력시 move가 잘 동작하는지")
    public void moveTest3() {
        assertSimpleTest(() -> {
            command("U", "UUU", "U");
            bridgeGame.move();
            assertThat(output())
                    .contains("[ERROR]");
        });
    }

    @Test
    @DisplayName(value = "retry 후 move가 잘 작동되는지")
    public void retryTest1() {
        assertSimpleTest(() -> {
            command("U", "U", "R", "D", "U", "D");
            bridgeGame.move();
            bridgeGame.retry();
            bridgeGame.move();
            assertThat(output())
                    .contains("[ O |   | O |   ]" + System.lineSeparator() + "[   | O |   | O ]");
        });
    }

    @Test
    @DisplayName(value = "retry 시 에러 표시")
    public void retryTest2() {
        assertSimpleTest(() -> {
            command("U", "U", "r", "R");
            bridgeGame.move();
            bridgeGame.retry();
            assertThat(output())
                    .contains("[ERROR]");
        });
    }

    @Test
    @DisplayName(value = "움직임이 지속되는지 확인")
    public void isEndTest1() {
        assertSimpleTest(() -> {
            command("U", "U");
            bridgeGame.move();

            assertThat(bridgeGame.isEnd())
                    .isEqualTo(false);
        });
    }


    @Test
    @DisplayName(value = "움직임이 지속되는지 확인")
    public void isEndTest2() {
        assertSimpleTest(() -> {
            command("U", "U");
            bridgeGame.move();

            assertThat(bridgeGame.isEnd())
                    .isEqualTo(false);
        });
    }
}