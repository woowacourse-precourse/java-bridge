package bridge;

import bridge.domain.Bridge;
import bridge.domain.GameRound;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameRoundTest extends NsTest {

    GameRound gameRound = new GameRound(new InputView(), new OutputView(), new Bridge(Arrays.asList("U", "D", "U", "D")));

    @DisplayName("첫번째 값이 U랑 동일한지 테스트")
    @Test
    void isWinTest() {
        assertSimpleTest(
                () -> {
                    run("U");
                    assertEquals(true, gameRound.isWin("U"));
                }
        );
    }

    @DisplayName("다른 값 입력 시 false 반환하는지 테스트")
    @Test
    void winRoundTestFalse() {
        assertSimpleTest(
                () -> {
                    run("U", "U");
                    assertEquals(false, gameRound.winRound());
                }
        );
    }

    @DisplayName("전체 입력값 동일하면 true 반환하는지 테스트")
    @Test
    void winRoundTestTrue() {
        assertSimpleTest(
                () -> {
                    run("U", "D", "U", "D");
                    assertEquals(true, gameRound.winRound());
                }
        );
    }

    @DisplayName("마지막이 아닌 N번째 라운드면 true 반환")
    @Test
    void isContinueRoundTrue() {
        assertSimpleTest(
                () -> {
                    run("U");
                    assertEquals(true, gameRound.isContinueRound());
                }
        );
    }

    @Override
    public void runMain() {
        gameRound.winRound();
    }
}
