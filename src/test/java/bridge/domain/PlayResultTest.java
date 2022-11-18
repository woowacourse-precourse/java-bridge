package bridge.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayResultTest {

    PlayResult playResult;

    @BeforeEach
    void setup() {
        playResult = new PlayResult();
    }

    @DisplayName("다리를 건널 수 있고, 위 방향이면 UP")
    @Test
    void 건널_수_있고_위_방향은_UP() {
        playResult.updateResult("U", true);

        assertThat(playResult)
                .extracting("playResult", InstanceOfAssertFactories.LIST)
                .first(new InstanceOfAssertFactory<>(MoveStatus.class, Assertions::assertThat))
                .isEqualTo(MoveStatus.UP);
    }

    @DisplayName("다리를 건널 수 있고, 아래 방향이면 DOWN")
    @Test
    void 건널_수_있고_아래_방향은_DOWN() {
        playResult.updateResult("D", true);

        assertThat(playResult)
                .extracting("playResult", InstanceOfAssertFactories.LIST)
                .first(new InstanceOfAssertFactory<>(MoveStatus.class, Assertions::assertThat))
                .isEqualTo(MoveStatus.DOWN);
    }

    @DisplayName("다리를 건널 수 없고, 위 방향은 UP_FAIL")
    @Test
    void 건널_수_없고_위_방향은_UP_FAIL() {
        playResult.updateResult("U", false);

        assertThat(playResult)
                .extracting("playResult", InstanceOfAssertFactories.LIST)
                .first(new InstanceOfAssertFactory<>(MoveStatus.class, Assertions::assertThat))
                .isEqualTo(MoveStatus.UP_FAIL);
    }

    @DisplayName("다리를 건널 수 없고, 아래 방향은 DOWN_FAIL")
    @Test
    void 건널_수_없고_아래_방향은_DOWN_FAIL() {
        playResult.updateResult("D", false);

        assertThat(playResult)
                .extracting("playResult", InstanceOfAssertFactories.LIST)
                .first(new InstanceOfAssertFactory<>(MoveStatus.class, Assertions::assertThat))
                .isEqualTo(MoveStatus.DOWN_FAIL);
    }

    @DisplayName("재시작 시 시도 횟수 증가")
    @Test
    void 재시작_시_시도_횟수_증가() {
        playResult.updateResult("D", false);
        int tryCountBeforeRetry = playResult.getTryCount();
        playResult.retry();

        assertThat(playResult.getTryCount()).isEqualTo(tryCountBeforeRetry + 1);
    }

    @DisplayName("재시작 시 실패 결과 삭제")
    @Test
    void 재시작_시_실패_결과_삭제() {
        playResult.updateResult("D", false);
        int playResultSizeBeforeRetry = playResult.getPlayResult().size();
        playResult.retry();

        assertThat(playResult.getPlayResult().size()).isEqualTo(playResultSizeBeforeRetry - 1);
    }
}