package bridge.game.status;

import bridge.game.context.BridgeGameContextFake;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayerUnitMoveStatusTest {

    @Test
    void 플레이어_이동상태에서_실패할경우_재시작상태로_넘어갑니다() {
        var actual = new PlayerUnitMoveStatus().next(new BridgeGameContextFake(), new InputView(), new OutputView());
        Assertions.assertThat(actual).isInstanceOf(RestartGameStatus.class);
    }


}