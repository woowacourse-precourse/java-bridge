package bridge.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.*;

class PlayResultTest {

    PlayResult playResult;

    @BeforeEach
    void setup() {
        playResult = new PlayResult();
    }

    @DisplayName("넘겨준 값과 동일 값이 저장된다.")
    @ParameterizedTest
    @EnumSource(names = {"UP", "DOWN", "UP_FAIL", "DOWN_FAIL"})
    void 넘겨준_값과_동일_값이_저장된다(MoveStatus moveStatus) {
        playResult.updateResult(moveStatus);

        assertThat(playResult)
                .extracting("playResult", InstanceOfAssertFactories.LIST)
                .first(new InstanceOfAssertFactory<>(MoveStatus.class, Assertions::assertThat))
                .isEqualTo(moveStatus);
    }

    @DisplayName("재시작 시 시도 횟수 증가")
    @Test
    void 재시작_시_시도_횟수_증가() {
        playResult.updateResult(MoveStatus.DOWN_FAIL);
        playResult.deletePreviousResult();

        assertThat(playResult.getTryCount().toString()).isEqualTo("2");
    }

    @DisplayName("재시작 시 실패 결과 삭제")
    @Test
    void 재시작_시_실패_결과_삭제() {
        playResult.updateResult(MoveStatus.DOWN_FAIL);
        int playResultSizeBeforeRetry = playResult.getPlayResult().size();
        playResult.deletePreviousResult();

        assertThat(playResult.getPlayResult().size()).isEqualTo(playResultSizeBeforeRetry - 1);
    }
}