package bridge.validator;

import bridge.condition.Condition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    private static final String DUMMY_INPUT = "";

    @Test
    void 모든_조건_통과() {
        // given
        List<Condition> conditions = List.of(getPassCondition(), getPassCondition());

        // when, then
        assertThatCode(() -> {
            Validator.validateConditions(conditions, DUMMY_INPUT);
        }).doesNotThrowAnyException();
    }

    @Test
    void 일부_조건_통과_실패() {
        // given
        List<Condition> conditions = List.of(getPassCondition(), getNotPassCondition());

        // when, then
        assertThatThrownBy(() -> {
            Validator.validateConditions(conditions, DUMMY_INPUT);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private Condition getPassCondition() {
        return new Condition() {
            @Override
            public boolean test(String input) {
                return true;
            }
        };
    }

    private Condition getNotPassCondition() {
        return new Condition() {
            @Override
            public boolean test(String input) {
                return false;
            }
        };
    }
}