package bridge.game.status;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.bridge.Bridge;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;
import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ResultVerificationStatusTest {

    @Test
    void 결과상태_다음은_종료상태입니다() {
        var status = new ResultVerificationStatus();
        var nextStatus = status.next(new FakeContext(), new InputView(), new OutputView());
        assertThat(nextStatus).isInstanceOf(GameEndStatus.class);
    }

    class FakeContext implements BridgeGameContext {

        @Override
        public void generateBridge(Bridge madeBridge) {

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
            return GameStatus.FAIL;
        }
    }
}