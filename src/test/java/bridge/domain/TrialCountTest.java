package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TrialCountTest {

    @Test
    void 숫자_1로_시작한다() {
        assertThat(new TrialCount().getCount()).isEqualTo(1);
    }

    @Test
    void 횟수가_1씩_증가한다() {
        TrialCount trialCount = new TrialCount();
        trialCount.increase();

        assertThat(trialCount.getCount()).isEqualTo(2);
    }
}
