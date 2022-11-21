package bridge.game.status;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.bridge.Bridge;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;
import bridge.game.BridgeGame;
import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RestartGameStatusTest extends NsTest {

    @Test
    void R을_입력하면_플레이어_이동_상태가_반환됩니다() {
        run("R");
        var status = new RestartGameStatus();
        var nextStatus = status.next(new FakeContext(), new InputView(), new OutputView());

        assertThat(nextStatus).isInstanceOf(PlayerUnitMoveStatus.class);
    }

    @Test
    void Q를_입력하면_결과_상태를_반환합니다() {
        run("Q");
        var status = new RestartGameStatus();
        var nextStatus = status.next(new FakeContext(), new InputView(), new OutputView());

        assertThat(nextStatus).isInstanceOf(ResultVerificationStatus.class);
    }

    @Override
    protected void runMain() {

    }

    class FakeContext implements BridgeGameContext {
        @Override
        public void generateBridge(Bridge madeBridge) {

        }

        @Override
        public BridgeGame getBridgeGame() {
            return null;
        }

        @Override
        public void writeHistory(String resultMap) {

        }

        @Override
        public String getCachedHistory() {
            return null;
        }

        @Override
        public Integer getRepeatCount() {
            return null;
        }

        @Override
        public void retry() {

        }

        @Override
        public void movePlayerUnit(BridgePosition movePosition) {

        }

        @Override
        public GameStatus gameStatus() {
            return null;
        }
    }
}