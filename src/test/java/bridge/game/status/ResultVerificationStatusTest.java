package bridge.game.status;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.game.context.FakeContext;
import bridge.utils.TestUtils;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ResultVerificationStatusTest {

    @Test
    void 결과상태_다음은_종료상태입니다() {

        var actual = TestUtils.statusNext(
                new ResultVerificationStatus(),
                new FakeContext()
        );

        assertThat(actual).isInstanceOf(GameEndStatus.class);

    }

}