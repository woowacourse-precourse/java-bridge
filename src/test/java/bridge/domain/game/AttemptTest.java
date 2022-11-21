package bridge.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static bridge.support.ErrorMessage.TOO_MANY_ATTEMPTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AttemptTest {

    Attempt attempt;

    @BeforeEach
    void init() {
        attempt = new Attempt();
    }

    @Test
    void Attempt를_생성하면_시도_횟수는_1이다() {
        //when
        int res = attempt.getAttempt();

        //then
        assertThat(res).isEqualTo(1);
    }

    @Test
    void addAttempt_시도_횟수는_1씩_추가된다() {
        //when
        attempt.addAttempt();

        //then
        assertThat(attempt.getAttempt()).isEqualTo(2);
    }

    @Test
    void addAttempt_시도_횟수가_int범위를_넘어가면_예외가_발생한다() {
        //given
        for (int i = 0; i < Integer.MAX_VALUE - 1; i++) {
            attempt.addAttempt();
        }

        //when
        assertThatThrownBy(() -> attempt.addAttempt())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_MANY_ATTEMPTS);
    }
}