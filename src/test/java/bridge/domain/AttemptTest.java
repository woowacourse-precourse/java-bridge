package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AttemptTest {

    @DisplayName("count값 반환")
    @Test
    void getCount() {
        // given
        Attempt user = createAttempt();

        // when

        // then
        assertThat(user.getCount()).isEqualTo(1);
    }

    @DisplayName("count값 증가")
    @Test
    void addCount() {
        // given
        Attempt user = createAttempt();
        user.addCount();
        user.addCount();

        // when

        // then
        assertThat(user.getCount()).isEqualTo(3);
    }

    Attempt createAttempt() {
        return new Attempt();
    }
}
