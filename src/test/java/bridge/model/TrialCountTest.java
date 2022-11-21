package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TrialCountTest {

    @DisplayName("처음 게임을 시작하면 시도 횟수는 1회이다.")
    @Test
    void firstTrial_메서드는_시도를_1회_했을_때의_TrialCount객체를_반환한다() {
        assertThat(TrialCount.firstTrial()).isEqualTo(new TrialCount(1));
    }

    @ParameterizedTest(name = "{0}번 시도 후에 increase 호출하면 {1}번 시도한 게 된다")
    @CsvSource({"0,1", "1,2", "100,101"})
    void increase_메서드는_기존_시도_횟수에_1_증가한_TrialCount객체를_반환한다(int trialCount, int expected) {
        assertThat(new TrialCount(trialCount).increase()).isEqualTo(new TrialCount(expected));
    }
}