package bridge.game.status;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.game.context.FakeContext;
import bridge.utils.TestUtils;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InitStatusTest {

    @Test
    void 초기상태_다음상태는_게임시작상태입니다() {

        var actual = TestUtils.statusNext(
                new InitStatus(),
                new FakeContext()
        );

        assertThat(actual).isInstanceOf(GameStartStatus.class);
    }

}