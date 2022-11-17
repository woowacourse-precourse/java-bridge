package bridge.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayResultTest {

    @DisplayName("다리를 건널 수 있고, 위 방향이면 UP")
    @Test
    void 건널_수_있고_위_방향은_UP() {
        PlayResult playResult = new PlayResult();
        playResult.updateResult("U", true);

        assertThat(playResult)
                .extracting("playResult", InstanceOfAssertFactories.LIST)
                .first(new InstanceOfAssertFactory<>(MoveStatus.class, Assertions::assertThat))
                .isEqualTo(MoveStatus.UP);
    }

    @DisplayName("다리를 건널 수 있고, 아래 방향이면 DOWN")
    @Test
    void 건널_수_있고_아래_방향은_DOWN() {
        PlayResult playResult = new PlayResult();
        playResult.updateResult("D", true);

        assertThat(playResult)
                .extracting("playResult", InstanceOfAssertFactories.LIST)
                .first(new InstanceOfAssertFactory<>(MoveStatus.class, Assertions::assertThat))
                .isEqualTo(MoveStatus.DOWN);
    }

    @DisplayName("다리를 건널 수 없고, 위 방향은 UP_FAIL")
    @Test
    void 건널_수_없고_위_방향은_UP_FAIL() {
        PlayResult playResult = new PlayResult();
        playResult.updateResult("U", false);

        assertThat(playResult)
                .extracting("playResult", InstanceOfAssertFactories.LIST)
                .first(new InstanceOfAssertFactory<>(MoveStatus.class, Assertions::assertThat))
                .isEqualTo(MoveStatus.UP_FAIL);
    }

    @DisplayName("다리를 건널 수 없고, 아래 방향은 DOWN_FAIL")
    @Test
    void 건널_수_없고_아래_방향은_DOWN_FAIL() {
        PlayResult playResult = new PlayResult();
        playResult.updateResult("D", false);

        assertThat(playResult)
                .extracting("playResult", InstanceOfAssertFactories.LIST)
                .first(new InstanceOfAssertFactory<>(MoveStatus.class, Assertions::assertThat))
                .isEqualTo(MoveStatus.DOWN_FAIL);
    }

}