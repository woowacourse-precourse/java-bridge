package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameStartStatusTest {


    @Test
    void 게임시작상태_다음은_게임_다리_생성_상태입니다() {
        var actual = new GameStartStatus().next(new BridgeGameContext(), new InputView(), new OutputView());
        Assertions.assertThat(actual)
                .isInstanceOf(GenerateBridgeStatus.class);
    }

}