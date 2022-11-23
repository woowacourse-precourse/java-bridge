package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultGeneratorTest {


    @DisplayName("성공 여부와 시도 횟수를 통해 게임 결과를 얻을 수 있다.")
    @Test
    void getResult() {
        // given
        boolean isEnd = true;
        int trial = 3;

        // when, then
        assertThat(ResultGenerator.generateResult(isEnd, trial)).isEqualTo(
                "게임 성공 여부: 성공\n" +
                        "총 시도한 횟수: 3"
        );
    }
}
