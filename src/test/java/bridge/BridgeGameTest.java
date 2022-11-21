package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.*;

class BridgeGameTest extends NsTest {

    private final BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeGame game = new BridgeGame(numberGenerator);

    @DisplayName("완벽한 이동을 테스트한다.")
    @Test
    void move() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O ]", "[   ]",
                    "[ O |   ]", "[   | O ]",
                    "[ O |   | O ]", "[   | O |   ]"
            );
        },1, 0, 1);
    }

    @DisplayName("실패한 이동을 테스트한다.")
    @Test
    void moveFail() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "[ O ]", "[   ]",
                    "[ O |   ]", "[   | O ]",
                    "[ O |   |   ]", "[   | O | X ]"
            );
        },1, 0, 1);
    }

    @DisplayName("도중에 실패한 이동을 테스트한다.")
    @Test
    void moveFailMiddle() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            assertThat(output()).contains(
                    "[ O ]", "[   ]",
                    "[ O | X ]", "[   |   ]"
            );
        },1, 0, 1);
    }

    @Override
    protected void runMain() {
        game.start();
    }
}