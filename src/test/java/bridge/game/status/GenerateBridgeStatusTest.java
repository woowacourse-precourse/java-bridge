package bridge.game.status;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.game.context.FakeContext;
import bridge.utils.TestUtils;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GenerateBridgeStatusTest extends NsTest {


    @Test
    void 다리생성_상태_다음_플레이어_이동_상태입니다() {
        run("3");

        var actual = TestUtils.statusNext(
                new GenerateBridgeStatus(),
                new FakeContext()
        );

        assertThat(actual).isInstanceOf(PlayerUnitMoveStatus.class);
    }

    @Override
    protected void runMain() {

    }
}