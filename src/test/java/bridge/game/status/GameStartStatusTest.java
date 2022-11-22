package bridge.game.status;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.game.context.FakeContext;
import bridge.utils.TestUtils;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameStartStatusTest {

    @Test
    void 게임시작상태_다음은_게임_다리_생성_상태입니다() {

        var actual = TestUtils.statusNext(
                new GameStartStatus(),
                new FakeContext()
        );

        assertThat(actual).isInstanceOf(GenerateBridgeStatus.class);
    }

}