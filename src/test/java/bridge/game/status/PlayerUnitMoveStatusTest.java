package bridge.game.status;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.code.GameStatus;
import bridge.game.context.FakeContext;
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
        var actual = status.next(new FakeContext(GameStatus.FAIL), new InputView(), new OutputView());

        assertThat(actual).isInstanceOf(RestartGameStatus.class);
    }

    @Test
    void 성공한경우_다음_상태는_결과확인_상태입니다() {
        var status = new PlayerUnitMoveStatus();
        var actual = status.next(new FakeContext(GameStatus.CLEAR), new InputView(), new OutputView());

        assertThat(actual).isInstanceOf(ResultVerificationStatus.class);
    }


}