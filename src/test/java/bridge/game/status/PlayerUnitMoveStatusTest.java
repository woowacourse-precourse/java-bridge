package bridge.game.status;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.bridge.Bridge;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;
import bridge.game.BridgeGame;
import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayerUnitMoveStatusTest {

    @Test
    void 실패한경우_다음상태는_재시작요청_상태입니다() {
        var status = new PlayerUnitMoveStatus();
        var actual = status.next(new FakeStatus(GameStatus.FAIL), new InputView(), new OutputView());

        assertThat(actual).isInstanceOf(RestartGameStatus.class);
    }

    @Test
    void 성공한경우_다음_상태는_결과확인_상태입니다() {
        var status = new PlayerUnitMoveStatus();
        var actual = status.next(new FakeStatus(GameStatus.CLEAR), new InputView(), new OutputView());

        assertThat(actual).isInstanceOf(ResultVerificationStatus.class);
    }


    class FakeStatus implements BridgeGameContext {
        private final GameStatus gameStatus;

        public FakeStatus(GameStatus gameStatus) {
            this.gameStatus = gameStatus;
        }

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
            return gameStatus;
        }
    }

}