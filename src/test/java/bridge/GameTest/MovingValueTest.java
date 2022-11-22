package bridge.GameTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import game.BridgeGame;
import game.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InputCheck;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MovingValueTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("이동 칸 값과 실제 Bridge 칸 값이 같을때 제대로 처리가 되는지 확인")
    @Test
    void sameInputMovingValueAndBridgeValueProcessing() {
        String correct = bridgeGame.move("U","U");
        assertThat(correct.contains(GameResult.CORRECT_FLOOR.getResultMessage())).isTrue();
    }

    @DisplayName("이동 칸 값과 실제 Bridge 칸 값이 다를때 제대로 처리가 되는지 확인")
    @Test
    void differentInputMovingValueAndBridgeValueProcessing() {
        String wrong = bridgeGame.move("U","D");
        assertThat(wrong.contains(GameResult.WRONG_FLOOR.getResultMessage())).isTrue();
    }

    @DisplayName("이동 관련 값에 이상한 값이 들어올 때 제대로 처리가 되는지 확인")
    @Test
    void inputMovingExceptionProcessing() {
        assertSimpleTest(() -> {
            runException("A");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        InputCheck.movingValue();
    }
}
