package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InitStatusTest {

    @Test
    void 초기상태_다음상태는_게임시작상태입니다() {
        var actual = new InitStatus().next(new BridgeGameContext(), new InputView(), new OutputView());
        Assertions.assertThat(actual).isInstanceOf(GameStartStatus.class);
    }

}